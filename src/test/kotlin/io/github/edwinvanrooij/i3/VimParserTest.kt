package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.generic.DotfileParser
import io.github.edwinvanrooij.generic.Shortcut
import io.github.edwinvanrooij.vim.VimParser
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class VimParserTest {

    private lateinit var parser: DotfileParser

    @BeforeEach
    fun setUp() {
        parser = VimParser()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getMapping() {
        val s = "s"
        val S = "S"

        val sShortcut: Shortcut? = parser.getMapping(s)
        val SShortcut: Shortcut? = parser.getMapping(S)

        // Check if we actually got some shortcuts back
        assertNotNull(sShortcut)
        assertNotNull(SShortcut)

        // Check if the description matches expected
        assertEquals(fShortcut?.action, "fullscreen toggle")
        assertEquals(vShortcut?.action, "split toggle")
        assertEquals(f7Shortcut?.action, "exec google-chrome-stable")
    }
}