package com.wordline.quiz.quiz


import androidx.compose.runtime.Composable
import com.wordline.quiz.quiz.data.dataclass.Question

@Composable
fun questionScreen(id_quiz: Int?, onEndQuiz: (Int, Int) -> Unit, generatedQuiz: List<Question>) {

    val quiz = generatedQuiz
    println(quiz)
//    val quiz = Quiz(
//        1,
//        questionList = arrayListOf(
//            Question(
//                id = 1,
//                label = "Quelle est la capitale de la France ?",
//                correctId = 2,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Marseille"),
//                    Answer(id = 2, label = "Paris"),
//                    Answer(id = 3, label = "Lyon"),
//                    Answer(id = 4, label = "Nice")
//                )
//            ),
//            Question(
//                id = 2,
//                label = "Quel est le plus grand océan du monde ?",
//                correctId = 3,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Atlantique"),
//                    Answer(id = 2, label = "Arctique"),
//                    Answer(id = 3, label = "Pacifique"),
//                    Answer(id = 4, label = "Indien")
//                )
//            ),
//            Question(
//                id = 3,
//                label = "Combien de continents y a-t-il sur Terre ?",
//                correctId = 1,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "7"),
//                    Answer(id = 2, label = "5"),
//                    Answer(id = 3, label = "6"),
//                    Answer(id = 4, label = "4")
//                )
//            ),
//            Question(
//                id = 4,
//                label = "Qui a écrit 'Les Misérables' ?",
//                correctId = 4,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Émile Zola"),
//                    Answer(id = 2, label = "Gustave Flaubert"),
//                    Answer(id = 3, label = "Honoré de Balzac"),
//                    Answer(id = 4, label = "Victor Hugo")
//                )
//            ),
//            Question(
//                id = 5,
//                label = "Quelle est la formule chimique de l'eau ?",
//                correctId = 3,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "CO2"),
//                    Answer(id = 2, label = "H2"),
//                    Answer(id = 3, label = "H2O"),
//                    Answer(id = 4, label = "O2")
//                )
//            ),
//            Question(
//                id = 6,
//                label = "Quelle planète est la plus proche du Soleil ?",
//                correctId = 1,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Mercure"),
//                    Answer(id = 2, label = "Vénus"),
//                    Answer(id = 3, label = "Mars"),
//                    Answer(id = 4, label = "Terre")
//                )
//            ),
//            Question(
//                id = 7,
//                label = "Dans quel pays se trouve la Grande Muraille ?",
//                correctId = 2,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Japon"),
//                    Answer(id = 2, label = "Chine"),
//                    Answer(id = 3, label = "Corée"),
//                    Answer(id = 4, label = "Inde")
//                )
//            ),
//            Question(
//                id = 8,
//                label = "Quelle est la langue officielle du Brésil ?",
//                correctId = 4,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Espagnol"),
//                    Answer(id = 2, label = "Français"),
//                    Answer(id = 3, label = "Anglais"),
//                    Answer(id = 4, label = "Portugais")
//                )
//            ),
//            Question(
//                id = 9,
//                label = "Combien y a-t-il de couleurs dans un arc-en-ciel ?",
//                correctId = 2,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "5"),
//                    Answer(id = 2, label = "7"),
//                    Answer(id = 3, label = "6"),
//                    Answer(id = 4, label = "8")
//                )
//            ),
//            Question(
//                id = 10,
//                label = "Quel gaz les plantes utilisent-elles pour la photosynthèse ?",
//                correctId = 1,
//                answers = arrayListOf(
//                    Answer(id = 1, label = "Dioxyde de carbone"),
//                    Answer(id = 2, label = "Oxygène"),
//                    Answer(id = 3, label = "Azote"),
//                    Answer(id = 4, label = "Hydrogène")
//                )
//            )
//        )
//    )
//    var scoreMax by remember { mutableStateOf(quiz.size) }
//    var score by remember { mutableStateOf(0) }
//    var idQuestionEnCours by remember { mutableStateOf(1) }
//    var optnSelectionne by remember { mutableStateOf(-1) }
//    var progressBarVal by remember { mutableStateOf(0f) }
//
//    Column(
//        Modifier.fillMaxWidth().fillMaxHeight(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Column(
//            Modifier.fillMaxWidth().fillMaxHeight(),
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//            Box {
//                Column(
//                    Modifier.padding(30.dp),
//                    verticalArrangement = Arrangement.SpaceBetween,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "$score/$scoreMax : $idQuestionEnCours")
//                    Card(elevation = 6.dp) {
//                        Row(
//                            Modifier.background(Color.Blue.copy(0.1f)).padding(10.dp).clip(
//                                RoundedCornerShape(10.dp)
//                            ),
//                        ) {
//                            Text(
//                                text = quiz[idQuestionEnCours - 1].label,
//                                fontSize = 20.sp
//                            )
//
//                        }
//                    }
//                    Box {
//                        Spacer(Modifier.height(20.dp))
//                        Column {
//                            for (answer in quiz[idQuestionEnCours - 1].answers) {
//                                Row(
//                                    Modifier.selectable(
//                                        selected = (answer.id == optnSelectionne),
//                                        onClick = { optnSelectionne = answer.id }
//                                    ),
//                                    verticalAlignment = Alignment.CenterVertically
//                                ) {
//                                    RadioButton(
//                                        selected = (answer.id == optnSelectionne),
//                                        onClick = { optnSelectionne = answer.id }
//                                    )
//                                    Text(answer.label, fontSize = 20.sp)
//                                }
//                            }
//
//                        }
//                    }
//                }
//            }
//            Row(
//                verticalAlignment = Alignment.Bottom,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Button(
//                        onClick = {
//                            if (optnSelectionne != -1) {
//                                if (optnSelectionne == quiz[idQuestionEnCours - 1].correctId) {
//                                    score++
//                                }
//                                if (idQuestionEnCours < scoreMax) {
//                                    optnSelectionne = -1
//                                    idQuestionEnCours++
//                                    progressBarVal =
//                                        ((idQuestionEnCours.toFloat() / scoreMax.toFloat()))
//                                } else if (idQuestionEnCours >= scoreMax) {
//                                    onEndQuiz(
//                                        score,
//                                        scoreMax
//                                    )
//                                }
//                            }
//                        },
//                        Modifier.clip(CircleShape),
//                        colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color.Blue,
//                            contentColor = Color.White
//                        )
//
//                    ) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowForward, "Next")
//                        Text("Next", fontSize = 20.sp)
//
//                    }
//
//                    Spacer(Modifier.height(20.dp))
//                    LinearProgressIndicator(
//                        progress = progressBarVal,
//                        Modifier.fillMaxWidth().height(20.dp),
//                        Color.Blue,
//                        strokeCap = StrokeCap.Butt
//                    )
//                }
//            }
//        }
//
//
//    }
}

