package com.wonddak.switchview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wonddak.switchview.ui.theme.DefaultCheckColor
import com.wonddak.switchview.ui.theme.DefaultUnCheckColor

@Composable
fun SectionSwitchView(
    section: String,
    description: String = "",
    switchOn: Boolean = false,
    switchWidth: Dp = 72.dp,
    switchHeight: Dp = 40.dp,
    checkedColor: Color = DefaultCheckColor,
    uncheckedColor: Color = DefaultUnCheckColor,
    gapBetweenThumbAndTrackEdge: Dp = 8.dp,
    borderWidth: Dp = 2.dp,
    cornerSize: Int = 50,
    iconInnerPadding: Dp = 4.dp,
    thumbSize: Dp = 24.dp,
    updateCheckAction: (check: Boolean) -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column() {
            Text(
                text = section,
                fontWeight = FontWeight.SemiBold
            )
            if (description.isNotEmpty()) {
                Text(
                    text = description,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
        CustomSwitch(
            switchOn,
            switchWidth,
            switchHeight,
            checkedColor,
            uncheckedColor,
            gapBetweenThumbAndTrackEdge,
            borderWidth,
            cornerSize,
            iconInnerPadding,
            thumbSize,
        ) {
            updateCheckAction(it)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SectionSwitchViewPreview() {
    Column() {
        SectionSwitchView("test1")
        SectionSwitchView("test2", "description for test2",true)
    }

}