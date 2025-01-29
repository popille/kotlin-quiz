package com.wordline.quiz.cv.dialogs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.wordline.quiz.cv.components.ActiviteRow
import com.wordline.quiz.cv.components.CompetenceRow
import com.wordline.quiz.cv.components.ExperienceRow
import com.wordline.quiz.cv.components.FormationRow
import com.wordline.quiz.cv.components.QualiteRow

@Composable
fun DialogContent(showDialog: Boolean, onDismissRequest: () -> Unit, type: String) {
    var parentSize by remember { mutableStateOf(Size.Zero) }

    AnimatedVisibility(showDialog) {
        Dialog(onDismissRequest = onDismissRequest) {
            Card(Modifier.padding(10.dp)) {
                Column {
                    when (type) {
                        "Experience" -> {
                            ExperienceRow(
                                startDate = "Sept - Nov", endDate = "2024",
                                descriptionTitle = "Alternant développeur fullstack",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(15.dp), thickness = 1.dp)

                            ExperienceRow(
                                startDate = "Avr - Juin", endDate = "2024",
                                descriptionTitle = "Stagiaire développeur fullstack",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(20.dp), thickness = 1.dp)

                            ExperienceRow(
                                startDate = "Fev - Sept", endDate = "2023/24",
                                descriptionTitle = "Conseiller de vente",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                        }

                        "Formations" -> {
                            FormationRow(
                                startDate = "2024 - ", endDate = "",
                                descriptionTitle = "Management Du développement web",
                                city = "Lille",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(15.dp), thickness = 1.dp)

                            FormationRow(
                                startDate = "2021 -", endDate = "2024",
                                descriptionTitle = "Licence informatique",
                                city = "Amiens",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(20.dp), thickness = 1.dp)

                            FormationRow(
                                startDate = "2018 - ", endDate = "2021",
                                descriptionTitle = "Génie électrique",
                                city = "Le Creusot",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                        }

                        "Qualités" -> {
                            QualiteRow(
                                descriptionTitle = "Créatif",
                                descriptionText = "Capacité à trouver des solutions innovantes.",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(15.dp), thickness = 1.dp)

                            QualiteRow(
                                descriptionTitle = "Travail en équipe",
                                descriptionText = "Apprécie collaborer avec les autres pour atteindre des objectifs communs.",
                                onSizeChanged = { parentSize = it }
                            )
                        }

                        "Compétences" -> {
                            CompetenceRow(
                                descriptionTitle = "Développement Web",
                                descriptionText = "Compétences en front-end et back-end (HTML, CSS, JS, PHP).",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(15.dp), thickness = 1.dp)

                            CompetenceRow(
                                descriptionTitle = "Gestion de projet",
                                descriptionText = "Capacité à planifier, organiser et gérer des projets efficacement.",
                                onSizeChanged = { parentSize = it }
                            )
                        }

                        "Activités" -> {
                            ActiviteRow(
                                descriptionTitle = "Handball",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            Divider(Modifier.padding(15.dp), thickness = 1.dp)

                            ActiviteRow(
                                descriptionTitle = "Voyages",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                            ActiviteRow(
                                descriptionTitle = "Cuisine",
                                descriptionText = "Le Lorem Ipsum est simplement du faux texte...",
                                onSizeChanged = { parentSize = it }
                            )
                        }
                    }


                    Spacer(Modifier.height(15.dp))

                    Row(
                        Modifier.fillMaxWidth().padding(0.dp, 30.dp, 0.dp, 15.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { onDismissRequest() },
                            shape = CircleShape,
                            modifier = Modifier.size(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Blue,
                                contentColor = Color.White
                            )
                        ) {
                            Icon(
                                Icons.Rounded.Close,
                                contentDescription = "Close dialog"
                            )
                        }
                    }
                }
            }
        }
    }
}