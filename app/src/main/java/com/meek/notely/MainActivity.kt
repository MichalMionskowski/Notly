package com.meek.notely

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.meek.notely.notes.presentation.NotesScreen
import com.meek.notely.notes.presentation.NotesViewModel
import com.meek.notely.ui.theme.NotelyTheme

class MainActivity : ComponentActivity() {
    val notesViewModel: NotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotelyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesScreen(
                        modifier = Modifier.padding(innerPadding),
                        notesViewModel = notesViewModel
                    )
                }
            }
        }
    }
}
