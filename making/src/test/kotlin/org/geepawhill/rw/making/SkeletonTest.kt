package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Client(val connector: Connector) {
    fun connect(): Boolean = connector.connect()
    fun disconnect() = connector.disconnect()
    fun echo(text: String): Response {
        val request = Request.echoRequest(text)
        val result = connector.send(request.toJson())
        return Response.unsafeFromJson(result)
    }
}

class SkeletonTest {
    val commander = Commander()
    val connector = DirectConnector(commander)
    val client = Client(connector)

    @Test
    fun `echo request roundtrip`() {
        client.connect()
        val response = client.echo("Hi Mom & Dad!")
        assertThat(response).isEqualTo(Response.echo("Hi Mom & Dad!"))
    }
}