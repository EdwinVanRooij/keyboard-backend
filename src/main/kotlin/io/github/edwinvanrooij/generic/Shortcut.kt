package io.github.edwinvanrooij.generic

val MODE_NORMAL = "normal"
val MODE_INSERT = "insert"
val MODE_SELECT = "select"

abstract class Shortcut(
        val character: String,// the character this shortcut is focused on (e.g.: "a", "e", "k", etc)
        val action: String // executed action
) {
    override fun toString(): String {
        return "Shortcut(character='$character', action='$action')"
    }
}
