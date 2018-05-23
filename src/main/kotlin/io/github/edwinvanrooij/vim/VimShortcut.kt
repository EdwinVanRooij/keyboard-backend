package io.github.edwinvanrooij.vim

import java.util.*

val MODE_NORMAL = "normal"
val MODE_INSERT = "insert"
val MODE_VISUAL = "visual"
val MODE_COMMAND = "command"

val LEADER_KEY = "leader key"

val SHIFT = "Shift"
val CONTROL = "Control"
val ALT = "Alt"

class VimShortcut(
        var mode: String, // the mode in which the shortcut is executed
        var keyCombination: KeyCombination, // additional enhancements (i.e. control/shift)
        val action: String // executed action
) {
    override fun toString(): String {
        return "VimShortcut(mode='$mode', keyCombination=$keyCombination, action='$action')"
    }
}
