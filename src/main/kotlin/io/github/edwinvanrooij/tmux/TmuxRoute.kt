package io.github.edwinvanrooij.tmux

import com.google.gson.Gson
import spark.Request
import spark.Response
import spark.Route

@Suppress("FoldInitializerAndIfToElvis")
class TmuxRoute : Route {
    private val gson = Gson()
    private val parser = TmuxParser()

    override fun handle(request: Request?, response: Response?): Any {
//        val key = request?.queryParams("key")
//        if (key == null) throw Exception("Key received is null or empty.")
//        val shortcut = parser.getMapping(key)
//        return gson.toJson(shortcut)
        TODO()
    }
}