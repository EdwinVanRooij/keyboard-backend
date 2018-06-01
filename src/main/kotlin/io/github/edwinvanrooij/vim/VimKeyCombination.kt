package io.github.edwinvanrooij.vim

import io.github.edwinvanrooij.base.BaseKeyCombination
import java.util.*

class VimKeyCombination(
        var mode: String, // the mode in which the shortcut is executed
        val keys: Array<String> // list of keys that form this combination
): BaseKeyCombination() {

    override fun toString(): String {
        return "KeyCombination(mode='$mode', keys=${Arrays.toString(keys)})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VimKeyCombination

        if (mode.toLowerCase() != other.mode.toLowerCase()) return false
        if (!Arrays.equals(keys, other.keys)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = mode.hashCode()
        result = 31 * result + Arrays.hashCode(keys)
        return result
    }
}