package com.meek.notely.notes.domain

import com.meek.notely.notes.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    fun addNote(note: Note)

    fun deleteNote(noteId : String)
}