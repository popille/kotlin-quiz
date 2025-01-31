package com.wordline.quiz.quiz.data.dataclass

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val globalHttpClient = HttpClient {
    engine {

    }

    install(ContentNegotiation) {
        json(
            contentType = ContentType.Application.Json, // because Github is not returning an 'application/json' header
            json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
    }
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens("KaQaXPpc0ds4sbOVUBAl3rD3C5wiSmUi", "xyz111")
            }
        }
    }
}

class QuizApiDatasource {
    private val httpClient = globalHttpClient
    suspend fun postGenerateQuiz(prompt: String): Quiz {
        val response: HttpResponse = httpClient.post("https://api.mistral.ai/v1/chat/completions") {
            headers {
                append(HttpHeaders.Authorization, Auth.key.name)
            }
            contentType(ContentType.Application.Json)
            setBody(
                """{

                    "model": "mistral-small-latest",
                    "temperature": 1.5,
                    "top_p": 1,
                    "max_tokens": 0,
                    "stream": false,
                    "stop": "string",
                    "random_seed": 0,
                    "messages": [
                    {
                        "role": "user",
                        "content": "Who is the best French painter? Answer in one short sentence $prompt."
                    }
                    ],
                    "response_format": {
                    "type": "text"
                },
                    "tools": [
                    {
                        "type": "function",
                        "function": {
                        "name": "string",
                        "description": "",
                        "strict": false,
                        "parameters": {}
                    }
                    }
                    ],
                    "tool_choice": "auto",
                    "presence_penalty": 0,
                    "frequency_penalty": 0,
                    "n": 1,
                    "prediction": {
                    "type": "content",
                    "content": ""
                },
                    "safe_prompt": false

            }"""
            )
        }
        return response.body()
    }

}

