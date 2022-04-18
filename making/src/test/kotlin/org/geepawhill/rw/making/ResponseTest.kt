package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import org.junit.jupiter.api.Test

class ResponseTest {

    val state = State(listOf(1, 2), "north", 1, 1, "NORMAL")

    @Test
    fun `encodes correctly with state`() {
        val response = Response(
            "ERROR",
            mapOf(
                "message" to JsonPrimitive("a string")
            ),
            state
        )

        val expected =
            """{"result":"ERROR","data":{"message":"a string"},"state":{"position":[1,2],"direction":"north","shields":1,"shots":1,"status":"NORMAL"}}"""

        val actual = response.toJson()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `encodes correctly with null state`() {
        val response = Response(
            "ERROR",
            mapOf(
                "message" to JsonPrimitive("a string")
            )
        )

        val expected = """{"result":"ERROR","data":{"message":"a string"}}"""

        val actual = response.toJson()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `encode-decode works with state`() {
        val expected = Response(
            "ERROR",
            mapOf(
                "message" to JsonPrimitive("a string")
            ),
            state
        )

        val actual = Json.decodeFromString<Response>(expected.toJson())
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `encode-decode works with null state`() {
        val expected = Response(
            "ERROR",
            mapOf(
                "message" to JsonPrimitive("a string")
            ),
            null
        )

        val actual = Json.decodeFromString<Response>(expected.toJson())
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `makes error response correctly`() {
        assertThat(Response.error("That was dumb")).isEqualTo(
            Response("ERROR", mapOf("message" to JsonPrimitive("That was dumb")))
        )
    }

    @Test
    fun `makes echo response correctly`() {
        assertThat(Response.echo("resulting answer")).isEqualTo(
            Response("OK", mapOf("message" to JsonPrimitive("resulting answer")))
        )
    }

    @Test
    fun `unsafeFromJson builds Response`() {
        val response = Response(
            "a response", mapOf(
                "message" to JsonPrimitive("some message"),
                "integer" to JsonPrimitive(4)
            )
        )
        val result = Response.unsafeFromJson(response.toJson())
        assertThat(result).isEqualTo(response)
    }
}