package org.geepawhill.rw.making

import org.geepawhill.rw.transport.DirectConnector
import tornadofx.*


class MakerView : View("Robot World (Making)") {
    val serverModel = ServerModel()
    val serverView = ServerView(serverModel)

    val connector = DirectConnector(serverModel)
    val clientView = ClientView(connector)

    override val root = splitpane {
        this += clientView
        this += serverView
    }
}