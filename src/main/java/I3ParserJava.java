import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class I3ParserJava implements I3Parser {

    private String filename = "i3config";

    private static String i3Modifier = Shortcut.ALT;

    private Map<String, Shortcut> keyboard;

    public I3ParserJava() throws FileNotFoundException {
        keyboard = parseDotfile();
    }

    private Map<String, Shortcut> parseDotfile() throws FileNotFoundException {
        // Init result
        Map<String, Shortcut> result = new HashMap<>();

        // Get file from resources folder
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(filename)).getFile());

        // Iterate every line
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Check if the line is a shortcut
                if (line.matches("bindsym.*")) {

                    // Parse the shortcut
                    Shortcut s = parseShortcut(line);
                    result.put(s.getCharacter().toLowerCase(), s);
                }
            }
        }
        return result;
    }

    private Shortcut parseShortcut(String line) {
        Shortcut s = new Shortcut();

        // Cut the prefix 'bindsym'
        line = line.substring(8);

        // Check if it is prepended by the modifier key
        if (line.matches("\\$mod\\+.*")) {

            // Modifier key is used to prepend command
            s.setModifierKey(i3Modifier);
            line = line.substring(5); // Cut modifier out
        }

        // Check if control is used
        if (line.matches("Control\\+.*")) {
            s.addEnhancement(Shortcut.CONTROL);
            line = line.substring(8); // Cut modifier out
        }

        // Check if shift is used
        if (line.matches("Shift\\+.*")) {
            s.addEnhancement(Shortcut.SHIFT);
            line = line.substring(6); // Cut modifier out
        }

        // Finally, get the primary key
        String arr[] = line.split(" ", 2);
        s.setCharacter(arr[0]);
        s.setDescription(arr[1]);

//        System.out.println(String.format("Line '%s' -- s is '%s'", line, s));
//        System.out.println(s);
//        System.out.println(String.format("Line '%s' -- s is '%s'", line, s));
        return s;
    }


    @Override
    public Shortcut getMapping(String d) {
        return keyboard.get(d);
    }
}
