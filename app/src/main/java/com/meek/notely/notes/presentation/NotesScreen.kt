package com.meek.notely.notes.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NotesScreen(
    modifier: Modifier,
    notesViewModel: NotesViewModel
) {
    val (text, setText) = remember { mutableStateOf("") }
    val notesState = notesViewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskInput(
            inputText = text,
            onInputChange = { newText -> setText(newText) },
            onTaskSubmit = {
                notesViewModel.onEvent(
                    NotesEvent.OnAddNote(
                        NoteItem(
                            id = System.currentTimeMillis().toString(),
                            completed = false,
                            content = text
                        )
                    )
                )
            }
        )
        NotesList(
            notesList = notesState.value.notes
        )
    }
}

@Composable
fun TaskInput(
    modifier: Modifier = Modifier,
    inputText: String,
    onInputChange: (String) -> Unit,
    onTaskSubmit: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = inputText,
            onValueChange = onInputChange
        )

        Button(onClick = onTaskSubmit) {
            Text("Add Task")
        }
    }
}


@Composable
fun NotesList(modifier: Modifier = Modifier, notesList: List<NoteItem>) {
    Column(modifier = modifier.fillMaxWidth()) {
        notesList.forEach { note ->
            Text(text = note.content)
        }
    }
}