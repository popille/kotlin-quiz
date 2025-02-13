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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wordline.quiz.quiz.data.dataclass.Answer
import com.wordline.quiz.quiz.data.dataclass.Question
import com.wordline.quiz.quiz.data.dataclass.Quiz

@Composable
fun menuScreen(onStartQuiz: () -> Unit, onGenerateQuiz: () -> Unit) {
    val quiz = Quiz(

        questionList = arrayListOf(
            Question(
                id = 1,
                label = "Quelle est la capitale de la France ?",
                correctId = 2,
                answers = arrayListOf(
                    Answer(id = 1, label = "Marseille"),
                    Answer(id = 2, label = "Paris"),
                    Answer(id = 3, label = "Lyon"),
                    Answer(id = 4, label = "Nice")
                )
            ),
            Question(
                id = 2,
                label = "Quel est le plus grand océan du monde ?",
                correctId = 3,
                answers = arrayListOf(
                    Answer(id = 1, label = "Atlantique"),
                    Answer(id = 2, label = "Arctique"),
                    Answer(id = 3, label = "Pacifique"),
                    Answer(id = 4, label = "Indien")
                )
            ),
            Question(
                id = 3,
                label = "Combien de continents y a-t-il sur Terre ?",
                correctId = 1,
                answers = arrayListOf(
                    Answer(id = 1, label = "7"),
                    Answer(id = 2, label = "5"),
                    Answer(id = 3, label = "6"),
                    Answer(id = 4, label = "4")
                )
            ),
            Question(
                id = 4,
                label = "Qui a écrit 'Les Misérables' ?",
                correctId = 4,
                answers = arrayListOf(
                    Answer(id = 1, label = "Émile Zola"),
                    Answer(id = 2, label = "Gustave Flaubert"),
                    Answer(id = 3, label = "Honoré de Balzac"),
                    Answer(id = 4, label = "Victor Hugo")
                )
            ),
            Question(
                id = 5,
                label = "Quelle est la formule chimique de l'eau ?",
                correctId = 3,
                answers = arrayListOf(
                    Answer(id = 1, label = "CO2"),
                    Answer(id = 2, label = "H2"),
                    Answer(id = 3, label = "H2O"),
                    Answer(id = 4, label = "O2")
                )
            ),
            Question(
                id = 6,
                label = "Quelle planète est la plus proche du Soleil ?",
                correctId = 1,
                answers = arrayListOf(
                    Answer(id = 1, label = "Mercure"),
                    Answer(id = 2, label = "Vénus"),
                    Answer(id = 3, label = "Mars"),
                    Answer(id = 4, label = "Terre")
                )
            ),
            Question(
                id = 7,
                label = "Dans quel pays se trouve la Grande Muraille ?",
                correctId = 2,
                answers = arrayListOf(
                    Answer(id = 1, label = "Japon"),
                    Answer(id = 2, label = "Chine"),
                    Answer(id = 3, label = "Corée"),
                    Answer(id = 4, label = "Inde")
                )
            ),
            Question(
                id = 8,
                label = "Quelle est la langue officielle du Brésil ?",
                correctId = 4,
                answers = arrayListOf(
                    Answer(id = 1, label = "Espagnol"),
                    Answer(id = 2, label = "Français"),
                    Answer(id = 3, label = "Anglais"),
                    Answer(id = 4, label = "Portugais")
                )
            ),
            Question(
                id = 9,
                label = "Combien y a-t-il de couleurs dans un arc-en-ciel ?",
                correctId = 2,
                answers = arrayListOf(
                    Answer(id = 1, label = "5"),
                    Answer(id = 2, label = "7"),
                    Answer(id = 3, label = "6"),
                    Answer(id = 4, label = "8")
                )
            ),
            Question(
                id = 10,
                label = "Quel gaz les plantes utilisent-elles pour la photosynthèse ?",
                correctId = 1,
                answers = arrayListOf(
                    Answer(id = 1, label = "Dioxyde de carbone"),
                    Answer(id = 2, label = "Oxygène"),
                    Answer(id = 3, label = "Azote"),
                    Answer(id = 4, label = "Hydrogène")
                )
            )
        )
    )

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

                Row(
                    Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Blue.copy(0.1f))
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Général", fontSize = 20.sp)
                    Button(
                        onClick = { onStartQuiz() },
                        Modifier.clip(CircleShape)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, "Start the quiz")
                    }
                }


                Row(
                    Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Blue.copy(0.1f))
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Quiz", fontSize = 20.sp)
                    Button(onClick = { onStartQuiz() }, Modifier.clip(CircleShape)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, "Start the quiz")
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

