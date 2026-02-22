package com.meek.notely.notes.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
            notesList = notesState.value,
            onDeleteClick = { noteId: String ->
                notesViewModel.onEvent(
                    NotesEvent.OnDeleteNote(
                        noteId
                    )
                )
            }
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
fun NotesList(
    modifier: Modifier = Modifier,
    notesList: List<NoteItem>,
    onDeleteClick: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        notesList.forEach { note ->
            NoteItem(note, onDeleteClick = onDeleteClick)
        }
    }
}

@Composable
fun NoteItem(note: NoteItem, onDeleteClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = note.content, modifier = Modifier.weight(1f))

            IconButton(onClick = { onDeleteClick(note.id) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete note"
                )
            }
        }
    }
}

