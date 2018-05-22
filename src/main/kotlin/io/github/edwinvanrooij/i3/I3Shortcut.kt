package io.github.edwinvanrooij.i3

class I3Shortcut(
        var modifierKey: String, // what you need to press to activate
        var enhancements: MutableList<String>, // additional enhancements (i.e. control/shift)
        val character: String, // the character this shortcut is focused on (e.g.: "a", "e", "k", etc)
        val action: String // executed action
)
