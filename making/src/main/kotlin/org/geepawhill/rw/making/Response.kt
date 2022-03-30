package org.geepawhill.rw.making

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

@Serializable
data class Response(val result: String, val data: Map<String, JsonElement>, val state: State? = null) {
    fun toJson(): String {
        return Json.encodeToString(this)
    }
}