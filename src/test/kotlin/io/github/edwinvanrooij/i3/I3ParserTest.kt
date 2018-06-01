package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.ALT
import io.github.edwinvanrooij.CONTROL
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class I3ParserTest {

    private lateinit var parser: I3Parser

    @BeforeEach
    fun setUp() {
        parser = I3Parser()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getMapping() {
        val keyCombinations = arrayOf(
                I3KeyCombination(arrayOf(ALT, "f")),
                I3KeyCombination(arrayOf(ALT, "v")),
                I3KeyCombination(arrayOf(ALT, "d")),
                I3KeyCombination(arrayOf(ALT, CONTROL, "l")),
                I3KeyCombination(arrayOf(ALT, CONTROL, "h")),
                I3KeyCombination(arrayOf("F7")),
                I3KeyCombination(arrayOf("F1"))
        )
        for (k in keyCombinations) {
            val shortCut = parser.getMapping(k)
            assertNotNull(shortCut)
            println(shortCut?.action)
        }
    }
}