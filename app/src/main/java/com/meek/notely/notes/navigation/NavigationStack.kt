package com.meek.notely.notes.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.meek.notely.notes.presentation.Notes.NotesScreen
import com.meek.notely.notes.presentation.noteDetail.NoteDetailScreen

@Composable
fun NavigationStack(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen) {
        composable<Screen.MainScreen>{
            NotesScreen(
                modifier = modifier.padding(16.dp),
                notesViewModel = hiltViewModel(),
                onNoteClick = { id ->
                    navController.navigate(Screen.NoteScreen(noteId = id))
                }
            )
        }

        composable<Screen.NoteScreen>{ backStackEntry ->
            val id = backStackEntry.toRoute<Screen.NoteScreen>().noteId
            NoteDetailScreen(
                modifier = modifier,
                noteId = id
            )
        }
    }
}