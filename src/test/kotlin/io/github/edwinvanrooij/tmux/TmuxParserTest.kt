package io.github.edwinvanrooij.tmux

import io.github.edwinvanrooij.ALT
import io.github.edwinvanrooij.CONTROL
import io.github.edwinvanrooij.SHIFT
import io.github.edwinvanrooij.tmux.TmuxKeyCombination
import io.github.edwinvanrooij.tmux.TmuxParser
import io.github.edwinvanrooij.vim.TAB
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TmuxParserTest {

    private lateinit var parser: TmuxParser

    @BeforeEach
    fun setUp() {
        parser = TmuxParser()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getMapping() {
        val keyCombinations = arrayOf(
                TmuxKeyCombination(arrayOf(CONTROL, "h")),
                TmuxKeyCombination(arrayOf(CONTROL, "j")),
                TmuxKeyCombination(arrayOf(CONTROL, "k")),
                TmuxKeyCombination(arrayOf(CONTROL, "l")),
                TmuxKeyCombination(arrayOf(CONTROL, "v")),
                TmuxKeyCombination(arrayOf(CONTROL, "t"))
        )
        for (k in keyCombinations) {
            val shortCut = parser.getMapping(k)
            assertNotNull(shortCut)
            println(shortCut?.action)
        }
    }
}