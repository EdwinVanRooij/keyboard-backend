package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.generic.Shortcut

class I3Shortcut(
        var modifierKey: String, // what you need to press to activate
        var enhancements: MutableList<String>, // additional enhancements (i.e. control/shift)
        character: String,
        action: String
) : Shortcut(character = character, action = action)
