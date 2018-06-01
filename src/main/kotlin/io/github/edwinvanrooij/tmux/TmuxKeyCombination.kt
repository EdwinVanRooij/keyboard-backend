package io.github.edwinvanrooij.tmux

import io.github.edwinvanrooij.base.BaseKeyCombination
import java.util.*

class TmuxKeyCombination(
        val keys: Array<String> // list of keys that form this combination
) : BaseKeyCombination() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TmuxKeyCombination

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