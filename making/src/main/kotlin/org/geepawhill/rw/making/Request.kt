package org.geepawhill.rw.making

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Request(val command: String, val robot: String, val arguments: List<JsonPrimitive>) {
    fun toJson(): String {
        return Json.encodeToString(this)
    }

    companion object {

        fun unsafeFromJson(message: String): Request {
            return Json.decodeFromString(message)
        }

        fun echoRequest(text: String): Request {
            return Request("echo", "n/a", listOf(JsonPrimitive(text)))
        }
    }
}