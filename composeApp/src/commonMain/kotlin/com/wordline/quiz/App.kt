package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.wordline.quiz.quiz.classes.Answer
import com.wordline.quiz.quiz.classes.Question
import com.wordline.quiz.quiz.classes.Quiz
import com.wordline.quiz.quiz.scoreScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
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
        // questionScreen(quiz)
        scoreScreen(5, 10)
    }
}