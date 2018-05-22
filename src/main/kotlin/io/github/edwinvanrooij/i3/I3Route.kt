package io.github.edwinvanrooij.i3

import com.google.gson.Gson
import io.github.edwinvanrooij.generic.DotfileParser
import spark.Request
import spark.Response
import spark.Route

@Suppress("FoldInitializerAndIfToElvis")
class I3Route : Route {
    private val gson = Gson()
    private val parser: DotfileParser = I3Parser()

    override fun handle(request: Request?, response: Response?): Any {
        val key = request?.queryParams("key")
        if (key == null) throw Exception("Key received is null or empty.")
        val shortcut = parser.getMapping(key)
        return gson.toJson(shortcut)
    }
}