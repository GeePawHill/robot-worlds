package org.geepawhill.rw.transport

interface Receiver {
    fun receive(message: String): String
}
