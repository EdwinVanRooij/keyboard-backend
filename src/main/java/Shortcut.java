import java.util.ArrayList;
import java.util.List;

public class Shortcut {
    public static String CONTROL = "Control";
    public static String SHIFT = "Shift";
    public static String ALT = "Alt";

    private String modifierKey; // what you need to press to activate
    private List<String> enhancements; // additional enhancements (i.e. control/shift)
    private String character; // the primary character the shortcut is based upon
    private String action; // the action that gets performed
    private String description; // optional extra description

    public Shortcut() {
        enhancements = new ArrayList<>();
    }

    public Shortcut(String character, String modifierKey, String action, String description) {
        this.character = character;
        this.modifierKey = modifierKey;
        this.action = action;
        this.description = description;
        enhancements = new ArrayList<>();
    }

    public void addEnhancement(String key) {
        enhancements.add(key);
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getModifierKey() {
        return modifierKey;
    }

    public void setModifierKey(String modifierKey) {
        this.modifierKey = modifierKey;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shortcut{" +
                "modifierKey='" + modifierKey + '\'' +
                ", enhancements=" + enhancements +
                ", character='" + character + '\'' +
                ", action='" + action + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
