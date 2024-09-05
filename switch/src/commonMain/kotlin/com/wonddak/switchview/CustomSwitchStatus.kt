package com.wonddak.switchview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun rememberSwitchStatus(enabled: Boolean = false) = remember {
    mutableStateOf(CustomSwitchStatus(enabled))
}

class CustomSwitchStatus() {
    constructor(enabled: Boolean) : this() {
        this.enabled = enabled
    }

    var enabled by mutableStateOf(false)
        private set

    /**
     * Toggle Switch Status
     */
    fun toggle() {
        enabled = !enabled
    }

    /**
     * Switch Status to True
     */
    fun on() {
        enabled = true
    }

    /**
     * Switch Status to False
     */
    fun off() {
        enabled = false
    }
}