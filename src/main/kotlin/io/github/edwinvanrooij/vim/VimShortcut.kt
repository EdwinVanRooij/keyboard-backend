package io.github.edwinvanrooij.vim

import io.github.edwinvanrooij.generic.Shortcut

class VimShortcut(
        var mode: String, // the mode in which the shortcut is executed
        var enhancements: MutableList<String>, // additional enhancements (i.e. control/shift)
        character: String,
        action: String
) : Shortcut(character = character, action = action)
