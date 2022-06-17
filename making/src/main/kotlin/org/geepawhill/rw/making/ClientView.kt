package org.geepawhill.rw.making

import org.geepawhill.rw.transport.Connector
import org.geepawhill.rw.transport.Request
import tornadofx.*


class ClientView(private val connector: Connector) : Fragment() {

    override val root = borderpane {
        minWidth = 400.0
        top = vbox {
            stackpane {
                label("Client View")
            }
            toolbar {
                button("Echo Hey!") {
                    action {
                        connector.send(Request.echoRequest("Hey!").toJson())
                    }
                }
            }
        }
    }

    init {
        connector.connect()
    }
}