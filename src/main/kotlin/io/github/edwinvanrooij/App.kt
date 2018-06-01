package io.github.edwinvanrooij

import io.github.edwinvanrooij.i3.I3Route
import spark.Filter
import spark.Spark.*
import io.github.edwinvanrooij.vim.VimRoute

fun main(args: Array<String>) {
    enableCORS()
    get("/getI3Mapping", I3Route())
    get("/getVimMapping", VimRoute())
}

private fun enableCORS() {
    before(Filter { request, response ->
        response.header("Access-Control-Allow-Origin", "*")
        response.header("Access-Control-Request-Method", "*")
        response.header("Access-Control-Allow-Headers", "*")
    })
}
