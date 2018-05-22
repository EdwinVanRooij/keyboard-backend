package io.github.edwinvanrooij.vim

import java.util.*

class KeyCombination(
        val keys: Array<String> // list of keys that form this combination
) {
    override fun toString(): String {
        return "KeyCombination(keys=${Arrays.toString(keys)})"
    }
}