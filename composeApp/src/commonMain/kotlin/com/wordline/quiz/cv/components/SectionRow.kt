package com.wordline.quiz.cv.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SectionRow(
    title: String,
    onClick: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth().height(50.dp)
            .clickable { onClick() }
    ) {
        Box(Modifier.fillMaxWidth().padding(10.dp, 3.dp)) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    title,
                    Modifier.padding(10.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = "Ouvrir pop experience",
                    Modifier.padding(10.dp),
                    tint = Color.White
                )
            }
        }
    }
    Divider(startIndent = 35.dp)
}
