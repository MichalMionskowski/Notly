package com.meek.notely.notes.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(){

    @Serializable
    object MainScreen : Screen()

    @Serializable
    data class NoteScreen(val noteId: String) : Screen()
}

