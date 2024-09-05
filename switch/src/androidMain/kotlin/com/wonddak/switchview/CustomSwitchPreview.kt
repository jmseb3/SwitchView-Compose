package com.wonddak.switchview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    backgroundColor = 0xFFFFFFFF, showBackground = true, showSystemUi = false
)
@Composable
fun CustomSwitchPreview() {
    val status by rememberSwitchStatus(true)
    CustomSwitch(status)
}

@Preview(
    backgroundColor = 0xFFFFFFFF, showBackground = true, showSystemUi = false
)
@Composable
fun CustomSwitchSectionPreview() {
    val status by rememberSwitchStatus()
    SectionSwitchView(
        status = status,
        section = "Test",
        description = "description"
    )
}