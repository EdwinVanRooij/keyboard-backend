package io.github.edwinvanrooij.tmux

class TmuxShortcut(
        var keyCombination: TmuxKeyCombination, // additional enhancements (i.e. control/shift)
        val action: String // executed action
)
