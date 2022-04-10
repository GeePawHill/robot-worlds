package org.geepawhill.rw.making

interface Connector {
    fun connect(): Boolean
    fun send(message: String): String
    fun disconnect()
}