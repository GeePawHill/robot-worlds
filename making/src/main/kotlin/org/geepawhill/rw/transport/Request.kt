package org.geepawhill.rw.transport

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

        fun fromJson(message: String): Request {
            try {
                return unsafeFromJson(message)
            } catch (ignored: Exception) {
                return unparseableRequest()
            }
        }

        fun unsafeFromJson(message: String): Request {
            return Json.decodeFromString(message)
        }

        fun echoRequest(text: String): Request {
            return Request("echo", "n/a", listOf(JsonPrimitive(text)))
        }

        fun unparseableRequest(): Request {
            return Request("unparseable", "n/a", emptyList())
        }
    }
}