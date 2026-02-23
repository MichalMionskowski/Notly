package com.meek.notely.notes.presentation.noteDetail

import androidx.compose.ui.graphics.Color

sealed class NoteDetailState {
    data class Success(val noteDetailItem: NoteDetailItem) : NoteDetailState()
    object Loading : NoteDetailState()
    data class Error(val message: String) : NoteDetailState()
}

data class NoteDetailItem(
    val id: String,
    val completed: Boolean,
    val content: String,
    val description: String,
    val color: Color,
    val createdAt: String,
)