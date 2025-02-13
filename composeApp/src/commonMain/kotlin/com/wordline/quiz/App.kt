package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wordline.quiz.quiz.data.QuizRepository
import com.wordline.quiz.quiz.generationScreen
import com.wordline.quiz.quiz.menuScreen
import com.wordline.quiz.quiz.questionScreen
import com.wordline.quiz.quiz.scoreScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Serializable
object MenuScreen

@Serializable
data class QuestionScreen(
    val id_quiz: Int,
    val prompt: String
)

@Serializable
data class ScoreScreen(
    val score: Int,
    val scoreMax: Int
)

@Serializable
object GenerationScreen


@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController(),
) {
    MaterialTheme {


        NavHost(navController = navController, startDestination = MenuScreen) {
            composable<MenuScreen> {
                menuScreen(
                    onStartQuiz = { id_quiz: Int ->
                        navController.navigate(route = QuestionScreen(id_quiz, ""))
                    },
                    onGenerateQuiz = { navController.navigate(route = GenerationScreen) }
                )
            }
            composable<QuestionScreen> { args ->
                val questionScreen: QuestionScreen = args.toRoute<QuestionScreen>()
                val quizRepository: QuizRepository? = if (questionScreen.prompt.isNotEmpty()) {
                    QuizRepository(questionScreen.prompt)
                } else {
                    null
                }
                val questions by quizRepository?.questionState?.collectAsState()
                    ?: remember { mutableStateOf(emptyList()) }



                questionScreen(
                    id_quiz = questionScreen.id_quiz,
                    onEndQuiz = { score: Int,
                                  scoreMax: Int ->
                        navController.navigate(route = ScoreScreen(score, scoreMax))
                    },
                    generatedQuiz = questions
                )
            }
            composable<ScoreScreen> { backStackEntry ->
                val scoreScreen: ScoreScreen = backStackEntry.toRoute<ScoreScreen>()
                scoreScreen(
                    score = scoreScreen.score,
                    scoreMax = scoreScreen.scoreMax,
                    onEndScoreView = { navController.navigate(route = MenuScreen) }
                )
            }
            composable<GenerationScreen> {
                generationScreen(
                    onGenerateClick = { prompt: String ->
                        navController.navigate(route = QuestionScreen(0, prompt))
                    }
                )
            }

        }

    }
}