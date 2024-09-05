package com.wonddak.switchview

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wonddak.switchview.model.CustomSwitchOption

/**
 * CustomSwitch With Text
 * @see[CustomSwitchStatus]
 * @see[CustomSwitchOption]
 */
@Composable
fun SectionSwitchView(
    status: CustomSwitchStatus,
    option: CustomSwitchOption = CustomSwitchOption(),
    section: String,
    description: String = "",
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
            status,
            option
        )
    }
}