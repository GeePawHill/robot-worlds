package org.geepawhill.rw.making

class DirectConnector(val receiver: Receiver) : Connector {

    private var isConnected = false

    override fun connect(): Boolean {
        isConnected = true
        return true
    }

    override fun send(message: String): String {
        if (isConnected) return receiver.receive(message)
        return DISCONNECTED_RESPONSE_TEXT
    }

    override fun disconnect() {
        isConnected = false
    }

    companion object {
        val DISCONNECTED_RESPONSE_TEXT = Response.errorResponse("Service not connected.").toJson()
    }
}