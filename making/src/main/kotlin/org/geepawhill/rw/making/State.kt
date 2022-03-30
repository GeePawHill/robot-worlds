package org.geepawhill.rw.making

import kotlinx.serialization.Serializable

@Serializable
data class State(
    val position: List<Int>,
    val direction: String,
    val shields: Int,
    val shots: Int,
    val status: String
) {
}

