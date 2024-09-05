package com.wonddak.switchview.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomSwitchOption(
    /**
     * Size of Switch Width
     */
    var width: Dp = 72.dp,

    /**
     * Size of Switch Height
     */
    var height: Dp = 40.dp,

    /**
     * Color of Track
     */
    var trackColor: CustomSwitchColor = CustomSwitchColor(
        Color(0xFF6200EE),
        Color(0xFFe0e0e0)
    ),

    /**
     * Color of Thumb
     */
    var thumbColor: CustomSwitchColor = trackColor,

    /**
     * gap Between Thumb <---> TrackEdge
     */
    var gapBetweenThumbAndTrackEdge: Dp = 8.dp,

    /**
     * border width switch outside
     */
    var borderWidth: Dp = 2.dp,

    /**
     * corner Percent of switch
     */
    var cornerSize: Int = 50,

    /**
     * padding of thumbs icon
     */
    var iconInnerPadding: Dp = 4.dp,

    /**
     * thumb icon size
     */
    var thumbSize: Dp = 24.dp,

    /**
     * Thumb Icon When checked
     */
    val checkedIcon: Any = Icons.Filled.Done,

    /**
     * Thumb Icon When unchecked
     */
    val unCheckedIcon: Any = Icons.Filled.Close,

    /**
     * Thumb Icon Tint Color
     */
    var iconColor : CustomSwitchColor = CustomSwitchColor(
        Color.White,
        Color.White
    )
) {
    fun getIcon(enabled: Boolean) = if (enabled) checkedIcon else unCheckedIcon
}

/**
 * Color Class
 * @param[checkedColor] color when status true
 * @param[unCheckedColor] color when status false
 */
data class CustomSwitchColor(
    val checkedColor: Color,
    val unCheckedColor: Color,
) {
    fun getColor(enabled: Boolean) = if (enabled) checkedColor else unCheckedColor
}
