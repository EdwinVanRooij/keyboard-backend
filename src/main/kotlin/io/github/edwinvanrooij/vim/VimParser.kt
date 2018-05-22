package io.github.edwinvanrooij.vim

import io.github.edwinvanrooij.SHIFT
import java.io.File
import java.util.*


@Suppress("JoinDeclarationAndAssignment")
class VimParser {

    private val fileName: String = "vimrc"
    private var keyboard: Map<KeyCombination, VimShortcut> = HashMap()

    // Define what happens after the constructor was called
    init {
        keyboard = parseDotfile()
    }


    private fun parseDotfile(): Map<KeyCombination, VimShortcut> {
        val result = HashMap<KeyCombination, VimShortcut>()
        val file = File(Objects.requireNonNull(javaClass.classLoader.getResource(fileName)).file)

        val scanner = Scanner(file)
        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            if (isMapping(line)) {
                val keyCombination = parseVimShortcut(line)
                println(keyCombination)
//                result.put(keyCombination, vimShortCut)
            }
        }

        return result
    }


    private fun parseVimShortcut(line: String): VimShortcut {
        val vimBinding: String
        val vimCommand: String
        val vimAction: String

        // Set variables
        vimBinding = line.split("\\s".toRegex())[0]
        if (line.split("\\s".toRegex())[0] == "<silent>") {
            // Second word is silent -- omit the word
            vimCommand = line.split("\\s".toRegex())[2]
            vimAction = line.split("\\s".toRegex()).drop(3).joinToString { " " }
        } else {
            // Second word is not silent -- init normally
            vimCommand = line.split("\\s".toRegex())[1]
            vimAction = line.split("\\s".toRegex()).drop(2).joinToString { " " }
        }

        println("Vimbinding is $vimBinding")
        println("Vimcommand is $vimCommand")
        println("Vimaction is $vimAction")

        // Parse leader mapping (outlier)
        fun parseLeaderMapping(): VimShortcut? {
            if (vimBinding.toLowerCase() == "map" && vimAction[0] == "\\") {
                return VimShortcut(MODE_NORMAL, KeyCombination(arrayOf(vimCommand)), vimAction)
            }
            return null
        }

        // If this is a leader mapping, we're done here.
        val leaderMapping: VimShortcut? = parseLeaderMapping()
        if (leaderMapping != null) return leaderMapping

        fun parseMode() = when {
            vimBinding.startsWith("n") -> MODE_NORMAL
            vimBinding.startsWith("i") -> MODE_INSERT
            vimBinding.startsWith("c") -> MODE_COMMAND
            vimBinding.startsWith("v") -> MODE_VISUAL
            else -> throw Exception("Could not determine vim mode of mapping '$line'")
        }

        // get the key combination
        fun parseKeyCombination(): KeyCombination {
            // Simplest case first: Only one character
            if (vimCommand.length == 1) {
                // Return the character if it's lowercase
                return if (vimCommand.toLowerCase() == vimCommand)
                    KeyCombination(arrayOf(vimCommand))
                // Add a shift if it's uppercase
                else KeyCombination(arrayOf(SHIFT, vimCommand))
            }

            // Multiple characters

            TODO()
        }

        return VimShortcut(parseMode(), parseKeyCombination(), vimAction)
    }

    private fun isMapping(line: String): Boolean {
        // Get the first word of the line (split by space)
        val firstWord = line.split("\\s".toRegex())[0]

        // If it ends in 'map', and is not a comment: we got a mapping
        return firstWord.endsWith("map") && !firstWord.startsWith("\"")
    }

    private fun parseShortcut(line: String): VimShortcut {
        TODO()
        // Turn a line into

        var enhancements = arrayListOf<String>()
//
//        // Cut the prefix 'bindsym'
//        var line = linetje.substring(8)
//
//        // Check if it is prepended by the modifier key
//        if (line.matches("\\\$mod\\+.*".toRegex())) {
//
//            // Modifier key is used to prepend command
////            s.modifierKey = i3Modifier
//            line = line.substring(5) // Cut modifier out
//        }
//
//        // Check if control is used
//        if (line.matches("Control\\+.*".toRegex())) {
//            enhancements.add(CONTROL)
//            line = line.substring(8) // Cut modifier out
//        }
//
//        // Check if shift is used
//        if (line.matches("Shift\\+.*".toRegex())) {
//            enhancements.add(SHIFT)
//            line = line.substring(6) // Cut modifier out
//        }
//
//        // Finally, get the primary key
//        val character = line.split("\\s".toRegex())[0]
//
//        // Declare remainder of split words
//        val descriptionList: List<String> = line.split("\\s".toRegex()).drop(1)

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

    fun getMapping(keyCombination: KeyCombination): VimShortcut? {
        return keyboard[keyCombination]
    }
}
