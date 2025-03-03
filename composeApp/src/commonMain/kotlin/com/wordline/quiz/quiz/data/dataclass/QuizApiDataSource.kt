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
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val globalHttpClient = HttpClient {
    engine {

    }

    install(ContentNegotiation) {
        json(
            contentType = ContentType.Application.Json,
            json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
    }
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens(MISTRAL_APIKEY, "xyz111")
            }
        }
    }
}

class QuizApiDatasource {
    private val instruction =
        "Crée un quiz captivant au format JSON, adapté à un public général. Le quiz doit respecter les conditions suivantes :\n" +
                "Le quiz doit comporter exactement 10 questions.\n" +
                "Chaque question doit proposer 4 réponses.\n" +
                "Aucune question ni aucune réponse ne doit être dupliquée.\n" +
                "Varie la difficulté des questions, allant de facile à modérément difficile.\n" +
                "Utilise différents types de questions : faits, définitions, applications pratiques, comparaisons, etc.\n" +
                "Formule les questions de manière claire et concise, en évitant le jargon spécialisé sauf si nécessaire.\n" +
                "Pour les réponses incorrectes, propose des options plausibles qui pourraient représenter des erreurs courantes ou des idées fausses sur le sujet.\n" +
                "Assure-toi que la position de la réponse correcte varie (elle ne doit pas toujours être à la même position, par exemple alterne entre id 1, 2, 3 et 4).\n" +
                "Couvre différents aspects ou sous-thèmes du sujet principal pour offrir une vue d'ensemble complète.\n" +
                "Évite les questions controversées ou sensibles ; reste neutre et factuel.\n" +
                "Intègre, si possible, des éléments intéressants ou surprenants pour stimuler la curiosité.\n" +
                "Chaque question doit être indépendante, permettant de répondre dans n'importe quel ordre.\n" +
                "IMPORTANT : Vérifie que le JSON généré est conforme à la structure suivante et qu'il ne contient aucun texte ou commentaire en dehors du JSON : @Serializable\n" +
                "data class Question(\n" +
                "    val id: Int,\n" +
                "    val label: String,\n" +
                "    val correctId: Int,\n" +
                "    val answers: ArrayList<Answer>\n" +
                ")\n" +
                "data class Answer(val id: Int, val label: String)\n " +
                "Vérification préalable : Avant de soumettre le quiz, verifie minutieusement que toutes les questions et réponses sont cohérentes, uniques et conformes à la structure JSON demandée, sans erreurs ni incohérences." +
                "La réponse finale doit être uniquement du JSON et respecter exactement cette structure."

    private val safeInstruction = instruction.replace("\n", "\\n")

    private val httpClient = globalHttpClient
    suspend fun postGenerateQuiz(prompt: String): ArrayList<Question> {
        try {
            val response: HttpResponse =
                httpClient.post("https://api.mistral.ai/v1/chat/completions") {
                    headers { }
                    contentType(ContentType.Application.Json)
                    setBody(
                        """{
        "model": "mistral-small-latest",
        "messages": [
            {
                "role": "system",
                "content": "$safeInstruction"
            },
            {
                "role": "user",
                "content": "Sujet du quiz $prompt"
            }
        ]
    }"""
                    )
                }
            println("response de l'api => (${response})")
            val chatResponse = response.body<ChatResponse>()

            val rawQuizContent = chatResponse.choices.firstOrNull()?.message?.content

            val quizJsonString = rawQuizContent
                ?.trim()
                ?.removePrefix("```json")
                ?.removeSuffix("```")
                ?.trim()

            println("quiz ==> $quizJsonString")

            val quiz = quizJsonString?.let {
                Json.decodeFromString<ArrayList<Question>>(it)
            } ?: throw IllegalStateException("Le quiz n'a pas pu être extrait")

            return quiz

        } catch (e: Exception) {
            println("Erreur lors de l'appel : ${e.message}")
            throw e
        }
    }
}
