package org.geepawhill.rw.making

class Commander : Receiver {
    override fun receive(message: String): String {
        val request = Request.unsafeFromJson(message)
        val response = Response.echoResponse(request.arguments[0].content)
        return response.toJson()
    }

}