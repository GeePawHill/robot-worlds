package org.geepawhill.rw.making

class DirectConnector(val receiver: Receiver) {

    private var isConnected = false

    fun connect(): Boolean {
        isConnected = true
        return true
    }

    fun send(message: String): String {
        if (isConnected) return receiver.receive(message)
        return DISCONNECTED_RESPONSE_TEXT
    }

    fun disconnect() {
        isConnected = false
    }

    companion object {
        val DISCONNECTED_RESPONSE_TEXT = Response.errorResponse("Service not connected.").toJson()
    }
}