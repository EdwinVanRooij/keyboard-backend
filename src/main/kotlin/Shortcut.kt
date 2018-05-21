class Shortcut(
        var modifierKey: String = "", // what you need to press to activate
        var enhancements: MutableList<String> = ArrayList(), // additional enhancements (i.e. control/shift)
        var character: String = "", // the primary character the shortcut is based upon
        var description: String = "" // optional extra description
)
