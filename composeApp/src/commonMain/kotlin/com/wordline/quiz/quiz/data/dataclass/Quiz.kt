package com.wordline.quiz.quiz.data.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(val id: Int, val questionList: ArrayList<Question>)
