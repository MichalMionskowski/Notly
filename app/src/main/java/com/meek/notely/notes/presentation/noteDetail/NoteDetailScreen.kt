package com.meek.notely.notes.presentation.noteDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NoteDetailScreen(modifier: Modifier, noteId: String){
    Column(modifier = modifier) {
        Text("Brilliant details screen  ${noteId}")
    }
}