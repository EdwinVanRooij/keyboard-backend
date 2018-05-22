import spark.Filter

import spark.Spark.*

fun main(args: Array<String>) {
    enableCORS();
    get("/getI3Mapping", I3Route())
}

private fun enableCORS() {
    before(Filter { request, response ->
        response.header("Access-Control-Allow-Origin", "*")
        response.header("Access-Control-Request-Method", "*")
        response.header("Access-Control-Allow-Headers", "*")
    })
}
