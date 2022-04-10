package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import org.junit.jupiter.api.Test

class RequestTest {
    @Test
    fun `encodes correctly`() {
        val request = Request(
            "launch", "geepaw", listOf(
                JsonPrimitive(1),
                JsonPrimitive("a string")
            )
        )
        val expected = """{"command":"launch","robot":"geepaw","arguments":[1,"a string"]}"""
        println(request.toJson())
        assertThat(request.toJson()).isEqualTo(expected)
    }

    @Test
    fun `encode-decode works`() {
        val expected = Request(
            "launch", "geepaw", listOf(
                JsonPrimitive(1),
                JsonPrimitive("a string")
            )
        )
        val actual = Json.decodeFromString<Request>(expected.toJson())
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `makes echo request correctly`() {
        val request = Request.echoRequest("Hi Mom!")
        assertThat(request.command).isEqualTo("echo")
        assertThat(request.arguments[0].content).isEqualTo("Hi Mom!")
    }

    @Test
    fun `unsafeFromJson parses good value`() {
        val request = Request.echoRequest("Hi Mom!")
        assertThat(Request.unsafeFromJson(request.toJson())).isEqualTo(request)
    }
}