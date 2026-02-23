package com.meek.notely.notes.presentation.noteDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NoteDetailScreen(modifier: Modifier, viewModel: NoteDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    when (state) {
        is NoteDetailState.Success -> {
            Column(modifier = modifier) {
                Text("Brilliant details screen  ${(state as NoteDetailState.Success).noteDetailItem.content}")
            }
        }

        else -> {

        }
    }

}