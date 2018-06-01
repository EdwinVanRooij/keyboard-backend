package io.github.edwinvanrooij.vim

import io.github.edwinvanrooij.vim.VimKeyCombination
import io.github.edwinvanrooij.vim.VimParser
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
                VimKeyCombination("normal", arrayOf("Leader", "c")),
                VimKeyCombination("normal", arrayOf("f")),
                VimKeyCombination("normal", arrayOf("Shift", "d")),
                VimKeyCombination("normal", arrayOf("v", "i", "]")),
                VimKeyCombination("insert", arrayOf("Control", "a")),
                VimKeyCombination("visual", arrayOf("Control", "a")),
                VimKeyCombination("command", arrayOf("w", "!", "!"))
        )
        for (k in keyCombinations) {
            val shortCut = parser.getMapping(k)
            println(shortCut)
            assertNotNull(shortCut)
        }
    }
}