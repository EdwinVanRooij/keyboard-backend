import java.io.File
import java.util.*


class I3Parser {

    private val CONTROL = "Control";
    private val SHIFT = "Shift";
    private val ALT = "Alt";

    private val fileName: String = "i3config"
    private val i3Modifier: String = ALT
    private var keyboard: Map<String, Shortcut> = HashMap()

    // Define what happens after the constructor was called
    init {
        keyboard = parseDotfile()
    }

    private fun parseDotfile(): Map<String, Shortcut> {
        val result = HashMap<String, Shortcut>()

        val file = File(Objects.requireNonNull(javaClass.classLoader.getResource(fileName)).file)

        val scanner = Scanner(file)
        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            // Check if the line is a shortcut
            if (line.matches("bindsym.*".toRegex())) {

                // Parse the shortcut
                val s = parseShortcut(line)
                result[s.character.toLowerCase()] = s
            }
        }

        return result
    }

    private fun parseShortcut(linetje: String): Shortcut {
        val s = Shortcut()

        // Cut the prefix 'bindsym'
        var line = linetje.substring(8)

        // Check if it is prepended by the modifier key
        if (line.matches("\\\$mod\\+.*".toRegex())) {

            // Modifier key is used to prepend command
            s.modifierKey = i3Modifier
            line = line.substring(5) // Cut modifier out
        }

        // Check if control is used
        if (line.matches("Control\\+.*".toRegex())) {
            s.enhancements.add(CONTROL)
            line = line.substring(8) // Cut modifier out
        }

        // Check if shift is used
        if (line.matches("Shift\\+.*".toRegex())) {
            s.enhancements.add(SHIFT)
            line = line.substring(6) // Cut modifier out
        }

        // Finally, get the primary key
        s.character = line.split("\\s".toRegex())[0]

        // Declare remainder of split words
        val descriptionList: List<String> = line.split("\\s".toRegex()).drop(1)

        // Set the description with the remainder, if any
        if (descriptionList.isNotEmpty()) {
            s.description = descriptionList[0]

            for (item in descriptionList.slice(1 until descriptionList.size)) {
                s.description += " $item"
            }
        }
        return s
    }

    fun getMapping(d: String?): Shortcut? {
        return keyboard[d]
    }
}
