package com.meek.notely.notes.domain

import com.meek.notely.notes.domain.models.Note
import com.meek.notely.notes.domain.models.NoteDetail
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    fun getNoteDetailsById(noteId: String): Flow<NoteDetail>

    fun addNote(note: Note)

    fun deleteNote(noteId : String)

    fun updateNote(note: Note)
}