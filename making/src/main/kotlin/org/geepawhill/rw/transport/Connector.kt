package org.geepawhill.rw.transport

interface Connector {
    fun connect(): Boolean
    fun send(message: String): String
    fun disconnect()
}