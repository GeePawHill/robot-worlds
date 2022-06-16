package org.geepawhill.rw.making

import org.geepawhill.rw.command.Event

interface Watcher {
    fun notify(event: Event)

    companion object {
        val NONE = object : Watcher {
            override fun notify(event: Event) {
            }
        }
    }
}