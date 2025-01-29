package com.wordline.quiz.cv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import quiz.composeapp.generated.resources.Dimonika01
import quiz.composeapp.generated.resources.Res

@Composable
fun menu() {
    Column(
        Modifier.fillMaxWidth().fillMaxHeight().background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF0A0A0A),
                    Color(0xFF003366),
                    Color.Blue
                )
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(Res.drawable.Dimonika01), null,
                Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(2.dp)
                    .border(width = 2.dp, color = Color.Blue, shape = CircleShape)
                    .clip(CircleShape)
            )

            Text(
                "Cédric Popille",
                Modifier.padding(0.dp, 3.dp, 0.dp, 2.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                "cedric.popille@hotmail.fr",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )

            Spacer(Modifier.height(10.dp))
            Text(
                "Développeur web",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(Modifier.height(40.dp))


            sectionList()
        }
    }
}