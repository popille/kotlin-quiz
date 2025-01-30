package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wordline.quiz.quiz.menuScreen
import com.wordline.quiz.quiz.questionScreen
import com.wordline.quiz.quiz.scoreScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Serializable
object MenuScreen

@Serializable
data class QuestionScreen(
    val id_quiz: Int
)

@Serializable
data class ScoreScreen(
    val score: Int,
    val scoreMax: Int
)

@Composable
@Preview
fun App(navController: NavHostController = rememberNavController()) {
    MaterialTheme {


        NavHost(navController = navController, startDestination = MenuScreen) {
            composable<MenuScreen> {
                menuScreen(
                    onStartQuiz = { id_quiz: Int ->
                        navController.navigate(route = QuestionScreen(id_quiz))
                    }
                )
            }
            composable<QuestionScreen> { args ->
                val questionScreen: QuestionScreen = args.toRoute<QuestionScreen>()
                questionScreen(
                    id_quiz = questionScreen.id_quiz,
                    onEndQuiz = { score: Int,
                                  scoreMax: Int ->
                        navController.navigate(route = ScoreScreen(score, scoreMax))
                    }
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
        }

    }
}