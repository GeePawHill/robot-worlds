package org.geepawhill.rw.making

import org.geepawhill.rw.transport.DirectConnector
import tornadofx.*


class MakerView : View("Robot World (Making)") {
    val commander = Commander()
    val connector = DirectConnector(commander)
    val clientView = ClientView(connector)

    val serverView = ServerView()

    override val root = splitpane {
        this += clientView
        this += serverView
    }
}