package com.wordline.quiz.quiz.data

import com.wordline.quiz.quiz.data.dataclass.Question
import com.wordline.quiz.quiz.data.dataclass.QuizApiDatasource
import com.wordline.quiz.quiz.data.datasource.MockDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizRepository(prompt: String) {

    private val mockDataSource = MockDataSource()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val _questionState = MutableStateFlow(listOf<Question>())
    private val quizApiDatasource = QuizApiDatasource()

    var questionState = _questionState

    init {
        generateQuiz(prompt)
    }


    private fun generateQuiz(prompt: String) {
        coroutineScope.launch {
            try {
                println("tentative appel api")
                _questionState.update {
                    quizApiDatasource.postGenerateQuiz(prompt = prompt)

                }
            } catch (e: Exception) {
                _questionState.update {
                    mockDataSource.generateQuestionsList()
                }
            }
        }
    }


}