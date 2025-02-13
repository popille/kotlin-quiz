package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wordline.quiz.quiz.data.QuizRepository
import com.wordline.quiz.quiz.data.dataclass.Question
import com.wordline.quiz.quiz.data.dataclass.Quiz
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
    val prompt: String?,
    val precPrompt: String?
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

        val quizList = remember { mutableStateListOf<Quiz>() }

        NavHost(navController = navController, startDestination = MenuScreen) {
            composable<MenuScreen> {
                menuScreen(
                    onStartQuiz = { selectedQuiz: String ->
                        navController.navigate(
                            route = QuestionScreen(
                                prompt = "",
                                precPrompt = selectedQuiz
                            )
                        )
                    },
                    onGenerateQuiz = { navController.navigate(route = GenerationScreen) },
                    quizList = quizList
                )
            }
            composable<QuestionScreen> { args ->
                val questionScreen: QuestionScreen = args.toRoute<QuestionScreen>()

                val questions = remember { mutableStateListOf<Question>() }

                if (questionScreen.precPrompt?.isNotEmpty() == true) {

                    val existingQuiz = quizList.find { it.nom == questionScreen.precPrompt }
                    if (existingQuiz != null) {
                        questions.clear()
                        questions.addAll(existingQuiz.questionList)
                    }
                } else {
                    val quizRepository: QuizRepository? = remember(questionScreen.prompt) {
                        if (questionScreen.prompt?.isNotEmpty() == true) {
                            QuizRepository(questionScreen.prompt)
                        } else null
                    }

                    val fetchedQuestions by quizRepository?.questionState?.collectAsState()
                        ?: remember { mutableStateOf(emptyList()) }

                    if (fetchedQuestions.isNotEmpty() && quizList.none { quiz -> quiz.questionList == fetchedQuestions }) {
                        questionScreen.prompt?.let { Quiz(it, fetchedQuestions) }
                            ?.let { quizList.add(it) }
                        questions.clear()
                        questions.addAll(fetchedQuestions)
                    }
                }

                questionScreen(
                    onEndQuiz = { score: Int, scoreMax: Int ->
                        navController.navigate(route = ScoreScreen(score, scoreMax))
                    },
                    quiz = questions
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
                        navController.navigate(
                            route = QuestionScreen(
                                prompt = prompt,
                                precPrompt = ""
                            )
                        )
                    }
                )
            }

        }

    }
}