package com.wonddak.switchview

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.wonddak.switchview.model.CustomSwitchOption

/**
 * CustomSwitch
 * @see[CustomSwitchStatus]
 * @see[CustomSwitchOption]
 */
@Composable
fun CustomSwitch(
    status: CustomSwitchStatus,
    option: CustomSwitchOption = CustomSwitchOption(),
) {
    val interactionSource = remember { MutableInteractionSource() }
    val switchOn = status.enabled

    val bias by animateFloatAsState(if (switchOn) 1f else -1f)
    val alignment by remember {
        derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
    }
    Box(
        modifier = Modifier
            .size(width = option.width, height = option.height)
            .border(
                width = option.borderWidth,
                color = option.trackColor.getColor(switchOn),
                shape = RoundedCornerShape(percent = option.cornerSize)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                status.toggle()
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .padding(
                    start = option.gapBetweenThumbAndTrackEdge,
                    end = option.gapBetweenThumbAndTrackEdge
                )
                .fillMaxSize(),
            contentAlignment = alignment
        ) {
            ThumbIcon(enabled = switchOn, option)
        }
    }
}

@Composable
private fun ThumbIcon(
    enabled: Boolean,
    option: CustomSwitchOption,
) {
    val modifier = Modifier
        .size(option.thumbSize)
        .background(
            color = option.thumbColor.getColor(enabled),
            shape = CircleShape
        )
        .padding(all = option.iconInnerPadding)

    val contentDescription = if (enabled) "Enabled" else "Disabled"
    when (val icon = option.getIcon(enabled)) {
        is ImageVector -> {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = modifier,
                tint = option.iconColor.getColor(enabled)
            )
        }

        is ImageBitmap -> {
            Icon(
                bitmap = icon,
                contentDescription = contentDescription,
                modifier = modifier,
                tint = option.iconColor.getColor(enabled)
            )
        }

        is Painter -> {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                modifier = modifier,
                tint = option.iconColor.getColor(enabled)
            )
        }

        else -> {
            throw IllegalStateException("This is not Support Type.. icon allow only [ImageVector,ImageBitmap,Painter]")
        }
    }

}