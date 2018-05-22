import com.google.gson.Gson
import spark.Request
import spark.Response
import spark.Route

class I3Route : Route {
    private val gson = Gson()
    private val parser = I3Parser()

    override fun handle(request: Request?, response: Response?): Any {
        var key = request?.queryParams("key")
        key = key?.toLowerCase()

        val shortcut = parser.getMapping(key)

        return gson.toJson(shortcut)
    }
}