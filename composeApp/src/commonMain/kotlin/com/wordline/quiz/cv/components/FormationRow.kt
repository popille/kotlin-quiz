package com.wordline.quiz.cv.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun FormationRow(
    startDate: String,
    endDate: String,
    city: String,
    descriptionTitle: String,
    descriptionText: String,
    onSizeChanged: (Size) -> Unit
) {
    Row(
        Modifier.fillMaxWidth().padding(10.dp)
            .onGloballyPositioned { coordinates -> onSizeChanged(coordinates.size.toSize()) }
    ) {
        Column {
            Text(startDate)
            Text(endDate)
        }

        Column(
            Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(descriptionTitle, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(3.dp))
            Text(city, color = Color.Gray)
            Spacer(Modifier.height(8.dp))
            Text(descriptionText)
        }
    }
}