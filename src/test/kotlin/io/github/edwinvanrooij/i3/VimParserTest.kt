package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.vim.KeyCombination
import io.github.edwinvanrooij.vim.VimParser
import io.github.edwinvanrooij.vim.VimShortcut
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class VimParserTest {

    private lateinit var parser: VimParser

    @BeforeEach
    fun setUp() {
        parser = VimParser()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getMapping() {
        val keyCombinations = arrayOf(
                KeyCombination("normal", arrayOf("Leader", "c")),
                KeyCombination("normal", arrayOf("f")),
                KeyCombination("normal", arrayOf("Shift", "d")),
                KeyCombination("normal", arrayOf("v", "i", "]")),
                KeyCombination("insert", arrayOf("Control", "a")),
                KeyCombination("visual", arrayOf("Control", "a")),
                KeyCombination("command", arrayOf("w", "!", "!"))
        )
        for (k in keyCombinations) {
            val shortCut = parser.getMapping(k)
            println(shortCut)
            assertNotNull(shortCut)
        }
    }
}