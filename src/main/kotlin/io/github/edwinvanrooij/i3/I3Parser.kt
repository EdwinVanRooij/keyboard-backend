package io.github.edwinvanrooij.i3

import io.github.edwinvanrooij.ALT
import io.github.edwinvanrooij.CONTROL
import io.github.edwinvanrooij.SHIFT
import java.io.File
import java.util.*
import kotlin.collections.ArrayList


class I3Parser {

    private val fileName: String = "i3config"
    private val i3Modifier: String = ALT
    private var keyboard: Map<I3KeyCombination, I3Shortcut> = HashMap()

    // Define what happens after the constructor was called
    init {
        keyboard = parseDotfile()
    }

    private fun parseDotfile(): Map<I3KeyCombination, I3Shortcut> {
        val result = HashMap<I3KeyCombination, I3Shortcut>()

        val file = File(Objects.requireNonNull(javaClass.classLoader.getResource(fileName)).file)

        val scanner = Scanner(file)
        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            // Check if the line is a shortcut
            if (line.matches("bindsym.*".toRegex())) {

                // Parse the shortcut
                val s = parseShortcut(line)
                result[s.keyCombination] = s
            }
        }

        return result
    }

    private fun parseShortcut(linetje: String): I3Shortcut {
        val array = ArrayList<String>()

        // Cut the prefix 'bindsym'
        var line = linetje.substring(8)

        // Check if it is prepended by the modifier key
        if (line.matches("\\\$mod\\+.*".toRegex())) {
            line = line.substring(5) // Cut modifier out
            array.add(i3Modifier)
        }

        // Check if control is used
        if (line.matches("Control\\+.*".toRegex())) {
            line = line.substring(8) // Cut modifier out
            array.add(CONTROL)
        }

        // Check if shift is used
        if (line.matches("Shift\\+.*".toRegex())) {
            line = line.substring(6) // Cut modifier out
            array.add(SHIFT)
        }

        // Finally, get the primary key
        val character = line.split("\\s".toRegex())[0]
        array.add(character)

        // Declare remainder of split words
        val descriptionList: List<String> = line.split("\\s".toRegex()).drop(1)

        // Set the action with the remainder, if any
        var action = ""
        if (descriptionList.isNotEmpty()) {
            action += descriptionList[0]

            for (item in descriptionList.slice(1 until descriptionList.size)) {
                action += " $item"
            }
        }
        return I3Shortcut(I3KeyCombination(array.toTypedArray()), action)
    }

    fun getMapping(keyCombination: I3KeyCombination): I3Shortcut? {
        return keyboard[keyCombination]
    }
}
