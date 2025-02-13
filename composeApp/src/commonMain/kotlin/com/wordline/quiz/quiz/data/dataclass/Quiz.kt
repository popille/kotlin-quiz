package com.wordline.quiz.quiz.data.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(val nom: String, val questionList: List<Question>)
