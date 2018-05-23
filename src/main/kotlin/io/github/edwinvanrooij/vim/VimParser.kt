package io.github.edwinvanrooij.vim

import java.io.File
import java.util.*


@Suppress("JoinDeclarationAndAssignment")
class VimParser {

    private val fileName: String = "vimrc-realdeal"
    //    private val fileName: String = "vimrc"
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
                val shortcut = parseVimShortcut(line)
                result[shortcut.keyCombination] = shortcut
            }
        }

        return result
    }


    private fun parseVimShortcut(rawLine: String): VimShortcut {
        // Strip silent from line
        val line = rawLine.replace("<silent>\\s".toRegex(), "")

        fun listToString(list: List<String>): String {
            return when {
                list.size == 1 -> list[0]
                list.size == 2 -> "${list[0]} ${list[1]}"
                else -> {
                    var result = list[0]
                    for (s in list.drop(1)) {
                        result += " $s"
                    }
                    result
                }
            }
        }

        val vimBinding: String
        val vimCommand: String
        val vimAction: String

        // Set variables
        vimBinding = line.split("\\s".toRegex())[0]
        vimCommand = line.split("\\s".toRegex())[1]
        vimAction = listToString(line.split("\\s".toRegex()).drop(2))

        // Parse leader mapping (outlier)
        fun parseLeaderMapping(): VimShortcut? {
            if (vimBinding.toLowerCase() == "map" && vimAction == "\\") {
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
            fun parseSingleAlphaNumeric(str: String): Array<String> {
                return if (str.toLowerCase() == str)
                    arrayOf(str)
                else
                    arrayOf(SHIFT, str.toLowerCase())
            }
            if (vimCommand.length == 1) return KeyCombination(parseSingleAlphaNumeric(vimCommand))

            // Multiple characters
            when {
                vimCommand.matches("<c-[a-z0-9]>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(CONTROL) + parseSingleAlphaNumeric(vimCommand.substring(3, 4)))
                vimCommand.matches("<leader>.*".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(LEADER) + parseSingleAlphaNumeric(vimCommand.substring(8, 9)))
                vimCommand.matches("<tab>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(TAB))
                vimCommand.matches("<s-tab>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(SHIFT, TAB))
                vimCommand.matches("<esc>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(ESC))
                vimCommand.matches("<backspace>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(BACKSPACE))
                vimCommand.matches("<s-c-\\w>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(SHIFT, CONTROL) + parseSingleAlphaNumeric(vimCommand.substring(5, 6)))
                vimCommand.matches("<f\\w>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(vimCommand.substring(1, 3).toLowerCase()))
                vimCommand.matches("<s-f\\w>".toRegex(RegexOption.IGNORE_CASE)) -> return KeyCombination(arrayOf(SHIFT, vimCommand.substring(3, 5).toLowerCase()))
            }

            // Parse each character by itself
            var result = mutableListOf<String>()
            for (c in vimCommand) {
                result = (result + (parseSingleAlphaNumeric(c.toString()))).toMutableList()
            }
            return KeyCombination(result.toTypedArray())
        }

        val s = VimShortcut(parseMode(), parseKeyCombination(), vimAction)
        println(s)
        return s
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
