package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.generic.DotfileParser
import io.github.edwinvanrooij.generic.Shortcut
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class I3ParserTest {

    private lateinit var parser: DotfileParser

    @BeforeEach
    fun setUp() {
        parser = I3Parser()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getMapping() {
        val fKey = "f"
        val vKey = "v"
        val f7Key = "F7"

        val fShortcut = parser.getMapping(fKey)
        val vShortcut = parser.getMapping(vKey)
        val f7Shortcut = parser.getMapping(f7Key)

        // Check if we actually got some shortcuts back
        assertNotNull(fShortcut)
        assertNotNull(vShortcut)
        assertNotNull(f7Shortcut)

        // Check if the description matches expected
        assertEquals(fShortcut?.action, "fullscreen toggle")
        assertEquals(vShortcut?.action, "split toggle")
        assertEquals(f7Shortcut?.action, "exec google-chrome-stable")
    }
}