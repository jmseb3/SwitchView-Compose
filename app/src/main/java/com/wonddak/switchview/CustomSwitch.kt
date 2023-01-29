package com.wonddak.switchview

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.wonddak.switchview.ui.theme.Default


@Composable
fun CustomSwitch(
    switchOn: Boolean = false,
    width: Dp = Default.width,
    height: Dp = Default.height,
    checkedTrackColor: Color = Default.checkedTrackColor,
    uncheckedTrackColor: Color = Default.uncheckedTrackColor,
    gapBetweenThumbAndTrackEdge: Dp = Default.gapBetweenThumbAndTrackEdge,
    borderWidth: Dp = Default.borderWidth,
    cornerSize: Int = Default.cornerSize,
    iconInnerPadding: Dp = Default.iconInnerPadding,
    thumbSize: Dp = Default.thumbSize,
    updateAction: (switchOn: Boolean) -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }

    val bias by animateFloatAsState(if (switchOn) 1f else -1f)
    val alignment by remember {
        derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
    }
    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .border(
                width = borderWidth,
                color = if (switchOn) checkedTrackColor else uncheckedTrackColor,
                shape = RoundedCornerShape(percent = cornerSize)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                updateAction(!switchOn)
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .padding(
                    start = gapBetweenThumbAndTrackEdge,
                    end = gapBetweenThumbAndTrackEdge
                )
                .fillMaxSize(),
            contentAlignment = alignment
        ) {

            Icon(
                imageVector = if (switchOn) Icons.Filled.Done else Icons.Filled.Close,
                contentDescription = if (switchOn) "Enabled" else "Disabled",
                modifier = Modifier
                    .size(size = thumbSize)
                    .background(
                        color = if (switchOn) checkedTrackColor else uncheckedTrackColor,
                        shape = CircleShape
                    )
                    .padding(all = iconInnerPadding),
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomSwitchPreview() {
    Column() {
        CustomSwitch()
        CustomSwitch(true)
    }
}