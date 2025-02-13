package com.wordline.quiz.quiz


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wordline.quiz.quiz.data.dataclass.Question

@Composable
fun questionScreen(onEndQuiz: (Int, Int) -> Unit, quiz: List<Question>) {

    println("depuis ecran de question = > $quiz")
    if (quiz.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(200.dp),
                strokeWidth = 20.dp,
                color = Color.Blue
            )
            Text(
                text = "Génération",
                color = Color.Black,
                fontSize = 20.sp
            )
        }

    } else {


        val scoreMax by remember { mutableStateOf(quiz.size) }
        var score by remember { mutableStateOf(0) }
        var idQuestionEnCours by remember { mutableStateOf(1) }
        var optnSelectionne by remember { mutableStateOf(-1) }
        var progressBarVal by remember { mutableStateOf(0f) }

        Column(
            Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Box {
                    Column(
                        Modifier.padding(30.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(elevation = 6.dp) {
                            Row(
                                Modifier.background(Color.Blue.copy(0.1f)).padding(10.dp).clip(
                                    RoundedCornerShape(10.dp)
                                ),
                            ) {
                                Text(
                                    text = quiz[idQuestionEnCours - 1].label,
                                    fontSize = 20.sp
                                )

                            }
                        }
                        Spacer(Modifier.height(40.dp))
                        Box {
                            Column {
                                for (answer in quiz[idQuestionEnCours - 1].answers) {
                                    Row(
                                        Modifier.selectable(
                                            selected = (answer.id == optnSelectionne),
                                            onClick = { optnSelectionne = answer.id }
                                        ),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = (answer.id == optnSelectionne),
                                            onClick = { optnSelectionne = answer.id }
                                        )
                                        Text(answer.label, fontSize = 20.sp)
                                    }
                                }

                            }
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(
                            onClick = {
                                if (optnSelectionne != -1) {
                                    if (optnSelectionne == quiz[idQuestionEnCours - 1].correctId) {
                                        score++
                                    }
                                    if (idQuestionEnCours < scoreMax) {
                                        optnSelectionne = -1
                                        idQuestionEnCours++
                                        progressBarVal += (1f / scoreMax)
                                    } else if (idQuestionEnCours >= scoreMax) {
                                        onEndQuiz(
                                            score,
                                            scoreMax
                                        )
                                    }
                                }
                            },
                            Modifier.clip(CircleShape),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Blue,
                                contentColor = Color.White
                            )

                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, "Next")
                            Text("Next", fontSize = 20.sp)

                        }
                        Spacer(Modifier.height(20.dp))
                        LinearProgressIndicator(
                            progress = progressBarVal,
                            Modifier.fillMaxWidth().height(20.dp),
                            Color.Blue,
                            strokeCap = StrokeCap.Butt
                        )
                    }
                }
            }


        }
    }
}

