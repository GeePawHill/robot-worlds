package org.geepawhill.rw.making

interface Receiver {
    fun receive(message: String): String
}
