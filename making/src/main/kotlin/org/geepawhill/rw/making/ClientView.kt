package org.geepawhill.rw.making

import org.geepawhill.rw.transport.Connector
import tornadofx.*


class ClientView(private val connector: Connector) : Fragment() {

    override val root = borderpane {
        minWidth = 400.0
        top = stackpane {
            label("Client View")
        }
    }
}