package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.base.BaseKeyCombination
import java.util.*

class I3KeyCombination(
        val keys: Array<String> // list of keys that form this combination
) : BaseKeyCombination() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as I3KeyCombination

        if (!Arrays.equals(keys, other.keys)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(keys)
    }

    override fun toString(): String {
        return "I3KeyCombination(keys=${Arrays.toString(keys)})"
    }
}