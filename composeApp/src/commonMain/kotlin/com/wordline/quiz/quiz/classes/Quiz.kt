package com.wordline.quiz.quiz.classes

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(val id: Int, val questionList: ArrayList<Question>)
