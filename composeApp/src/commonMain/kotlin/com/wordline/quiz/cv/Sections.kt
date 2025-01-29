package com.wordline.quiz.cv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wordline.quiz.cv.components.SectionRow
import com.wordline.quiz.cv.dialogs.DialogContent


@Composable
fun sectionList() {
    var showDialog by remember { mutableStateOf(false) }
    var showDialogFormation by remember { mutableStateOf(false) }
    var showDialogQuality by remember { mutableStateOf(false) }
    var showDialogSkills by remember { mutableStateOf(false) }
    var showDialogActivity by remember { mutableStateOf(false) }

    Box(
        Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray.copy(alpha = 0.5f))
    ) {
        Column {
            SectionRow(
                title = "Experiences",
                onClick = { showDialog = !showDialog })
            SectionRow(
                title = "Formations",
                onClick = { showDialogFormation = !showDialogFormation })
            SectionRow(
                title = "Qualités",
                onClick = { showDialogQuality = !showDialogQuality })
            SectionRow(
                title = "Compétences",
                onClick = { showDialogSkills = !showDialogSkills })
            SectionRow(
                title = "Activités",
                onClick = { showDialogActivity = !showDialogActivity })
        }
    }

    DialogContent(
        showDialog = showDialog,
        onDismissRequest = { showDialog = false },
        type = "Experience"
    )
    DialogContent(
        showDialog = showDialogFormation,
        onDismissRequest = { showDialogFormation = false },
        type = "Formations"
    )
    DialogContent(
        showDialog = showDialogQuality,
        onDismissRequest = { showDialogQuality = false },
        type = "Qualités"
    )
    DialogContent(
        showDialog = showDialogSkills,
        onDismissRequest = { showDialogSkills = false },
        type = "Compétences"
    )
    DialogContent(
        showDialog = showDialogActivity,
        onDismissRequest = { showDialogActivity = false },
        type = "Activités"
    )
}
