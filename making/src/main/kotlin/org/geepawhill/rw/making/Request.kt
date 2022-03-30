package org.geepawhill.rw.making

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

@Serializable
data class Request(val command: String, val robot: String, val arguments: List<JsonElement>) {
    fun toJson(): String {
        return Json.encodeToString(this)
    }
}