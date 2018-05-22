package io.github.edwinvanrooij.vim

import io.github.edwinvanrooij.CONTROL
import io.github.edwinvanrooij.SHIFT
import io.github.edwinvanrooij.generic.DotfileParser
import io.github.edwinvanrooij.generic.Shortcut
import java.io.File
import java.util.*


class VimParser : DotfileParser() {

    private val fileName: String = "vimrc"
    private var keyboard: Map<String, VimShortcut> = HashMap()

    // Define what happens after the constructor was called
    init {
        keyboard = parseDotfile()
    }


    private fun parseDotfile(): Map<String, VimShortcut> {
        val result = HashMap<String, VimShortcut>()

        val file = File(Objects.requireNonNull(javaClass.classLoader.getResource(fileName)).file)

        val scanner = Scanner(file)
        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            // Check if the line is a shortcut
            if (line.matches("bindsym.*".toRegex())) {

                // Parse the shortcut
                val s = parseShortcut(line)
                result[s.character.toLowerCase()] = s
            }
        }

        return result
    }

    private fun parseShortcut(linetje: String): VimShortcut {
        TODO()

        var enhancements = arrayListOf<String>()

        // Cut the prefix 'bindsym'
        var line = linetje.substring(8)

        // Check if it is prepended by the modifier key
        if (line.matches("\\\$mod\\+.*".toRegex())) {

            // Modifier key is used to prepend command
//            s.modifierKey = i3Modifier
            line = line.substring(5) // Cut modifier out
        }

        // Check if control is used
        if (line.matches("Control\\+.*".toRegex())) {
            enhancements.add(CONTROL)
            line = line.substring(8) // Cut modifier out
        }

        // Check if shift is used
        if (line.matches("Shift\\+.*".toRegex())) {
            enhancements.add(SHIFT)
            line = line.substring(6) // Cut modifier out
        }

        // Finally, get the primary key
        val character = line.split("\\s".toRegex())[0]

        // Declare remainder of split words
        val descriptionList: List<String> = line.split("\\s".toRegex()).drop(1)

        // Set the action with the remainder, if any
//        var action = ""
//        if (descriptionList.isNotEmpty()) {
//            action += descriptionList[0]
//
//            for (item in descriptionList.slice(1 until descriptionList.size)) {
//                action += " $item"
//            }
//        }
//        return VimShortcut()
    }


    override fun getMapping(d: String): Shortcut? {
        return keyboard[d]
    }
}
