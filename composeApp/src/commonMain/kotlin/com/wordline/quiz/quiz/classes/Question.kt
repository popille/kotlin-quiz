package com.wordline.quiz.quiz.classes

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val id: Int,
    val label: String,
    val correctId: Int,
    val answers: ArrayList<Answer>
)
