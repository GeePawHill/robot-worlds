package org.geepawhill.rw.making

import org.geepawhill.rw.transport.Connector
import org.geepawhill.rw.transport.Request
import org.geepawhill.rw.transport.Response

class ClientModel(val connector: Connector) {
    fun connect(): Boolean = connector.connect()
    fun disconnect() = connector.disconnect()
    fun echo(text: String): Response {
        val request = Request.echoRequest(text)
        val result = connector.send(request.toJson())
        return Response.unsafeFromJson(result)
    }
}