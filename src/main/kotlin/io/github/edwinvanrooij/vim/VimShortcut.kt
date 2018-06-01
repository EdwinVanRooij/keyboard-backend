package io.github.edwinvanrooij.vim

val MODE_NORMAL = "normal"
val MODE_INSERT = "insert"
val MODE_VISUAL = "visual"
val MODE_COMMAND = "command"

val TAB = "Tab"
val ESC = "Esc"
val BACKSPACE = "Backspace"

class VimShortcut(
        var keyCombination: VimKeyCombination,
        val action: String // executed action
) {
    override fun toString(): String {
        return "VimShortcut(keyCombination=$keyCombination, action='$action')"
    }
}
