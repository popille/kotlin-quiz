package com.wordline.quiz.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wordline.quiz.quiz.data.dataclass.Quiz

@Composable
fun menuScreen(
    onStartQuiz: (String) -> Unit,
    onGenerateQuiz: () -> Unit,
    quizList: SnapshotStateList<Quiz>
) {


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
                Text("Quiz", fontWeight = FontWeight.Bold, color = Color.Blue, fontSize = 60.sp)
            }
            Spacer(Modifier.padding(0.dp, 30.dp))
            Column(
                Modifier.padding(10.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                if (quizList.isEmpty()) {
                    Row(
                        Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Blue.copy(0.1f))
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Aucun quiz pour le moment",
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )

                    }
                }
                quizList.forEach { quiz ->

                    Row(
                        Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Blue.copy(0.1f))
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(quiz.nom, fontSize = 20.sp)
                        Button(
                            onClick = { onStartQuiz(quiz.nom) },
                            Modifier.clip(CircleShape)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, "Start the quiz")
                        }
                    }
                }


            }
        }
        Row(
            Modifier.fillMaxWidth().height(50.dp).background(Color.Blue.copy(0.7f))
                .clickable(onClick = { onGenerateQuiz() }),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Row( Modifier.fillMaxWidth(0.5f)){
            Text(
                "Générer mon quiz",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            //  }
        }
    }
}

