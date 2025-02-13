package com.wordline.quiz.quiz.data.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>
)

@Serializable
data class Choice(
    val index: Int,
    val message: ChatMessage
)

@Serializable
data class ChatMessage(
    val role: String,
    val content: String,
    val tool_calls: String? = null
)
