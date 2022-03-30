package org.geepawhill.rw.making

class DirectConnector(val receiver: Receiver) {

    private var isConnected = false

    fun connect(): Boolean {
        isConnected = true
        return true
    }

    fun send(message: String): String {
        if (isConnected) return receiver.receive(message)
        return DISCONNECTED_RESPONSE
    }

    fun disconnect() {
        isConnected = false
    }

    companion object {
        val DISCONNECTED_RESPONSE = "ERROR: Not Connected."
    }
}