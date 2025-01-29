package com.wordline.quiz.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun scoreScreen(score: Int, scoreMax: Int) {
    val score by remember { mutableStateOf(score) }
    val scoreMax by remember { mutableStateOf(scoreMax) }

    Column(
        Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(Modifier.padding(20.dp), elevation = 6.dp, shape = RoundedCornerShape(16.dp)) {
            Column(
                Modifier.fillMaxWidth().background(Color.Blue.copy(0.1f)).padding(0.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("score", fontSize = 20.sp)
                Spacer(Modifier.height(10.dp))
                Text("$score out of $scoreMax", fontSize = 25.sp)
                Spacer(Modifier.height(10.dp))
                Button(onClick = {}, Modifier.clip(CircleShape)) {
                    Icon(Icons.Default.Refresh, "Retake the quiz")
                    Text("Retake the Quiz")
                }
            }
        }
    }
}


