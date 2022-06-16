package org.geepawhill.rw.making

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.geepawhill.rw.transport.DirectConnector
import org.geepawhill.rw.transport.Response
import org.junit.jupiter.api.Test

class SkeletonTest {
    val commander = Commander()
    val connector = DirectConnector(commander)
    val client = ClientModel(connector)

    @Test
    fun `echo request roundtrip`() {
        client.connect()
        val response = client.echo("Hi Mom & Dad!")
        assertThat(response).isEqualTo(Response.echo("Hi Mom & Dad!"))
    }
}