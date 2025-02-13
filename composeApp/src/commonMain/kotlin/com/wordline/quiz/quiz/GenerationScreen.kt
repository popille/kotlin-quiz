package com.wordline.quiz.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun generationScreen(onGenerateClick: (String) -> Unit) {
    var prompt by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxWidth().fillMaxHeight().padding(0.dp, 20.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Générer mon quiz",
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    fontSize = 40.sp
                )
            }
            Spacer(Modifier.padding(0.dp, 30.dp))
            Column(
                Modifier.fillMaxWidth().padding(20.dp, 0.dp)
            ) {
                Text("Sujet", fontSize = 24.sp)
                Spacer(Modifier.padding(0.dp, 5.dp))

                OutlinedTextField(
                    value = prompt,
                    onValueChange = { prompt = it },
                    Modifier.fillMaxWidth()
                )
                Spacer(Modifier.padding(0.dp, 5.dp))
                Button(
                    onClick = { onGenerateClick(prompt.trim()) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Générer", fontSize = 25.sp)
                }
            }
        }
    }

}




