package org.geepawhill.rw.making

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Response(val result: String, val data: Map<String, JsonElement>, val state: State? = null) {
    fun toJson(): String {
        return Json.encodeToString(this)
    }

    companion object {
        fun unsafeFromJson(message: String): Response {
            return Json.decodeFromString(message)
        }

        fun echo(message: String): Response {
            return Response("OK", mapOf("message" to JsonPrimitive("$message")))
        }

        fun error(message: String): Response {
            return Response("ERROR", mapOf("message" to JsonPrimitive(message)))
        }

        fun unparseableRequest(): Response {
            return error("Can not parse Request.")
        }

        fun unknownCommandError(command: String): Response {
            return error("Unknown command: [$command]")
        }

        fun unparseableCommand(): Response {
            return error("Could not parse arguments")
        }
    }
}