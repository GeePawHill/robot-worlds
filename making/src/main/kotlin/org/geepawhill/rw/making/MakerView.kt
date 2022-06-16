package org.geepawhill.rw.making

import tornadofx.*


class MakerView : View("Robot World (Making)") {
    val serverView = ServerView()
    val clientView = ClientView()
    override val root = splitpane {
        this += clientView
        this += serverView
    }
}