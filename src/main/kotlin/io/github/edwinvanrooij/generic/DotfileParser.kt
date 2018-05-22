package io.github.edwinvanrooij.generic

abstract class DotfileParser {
    abstract fun getMapping(d: String): Shortcut?
}

