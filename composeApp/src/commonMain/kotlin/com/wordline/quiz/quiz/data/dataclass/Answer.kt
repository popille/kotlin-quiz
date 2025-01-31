package com.wordline.quiz.quiz.data.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Answer(val id: Int, val label: String)
