package io.github.edwinvanrooij.vim

import java.util.*

class KeyCombination(
        val keys: Array<String> // list of keys that form this combination
) {
    override fun toString(): String {
        return "KeyCombination(keys=${Arrays.toString(keys)})"
    }

    override fun equals(other: Any?): Boolean {
        other as KeyCombination

        if (!Arrays.equals(keys, other.keys)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(keys)
    }

}