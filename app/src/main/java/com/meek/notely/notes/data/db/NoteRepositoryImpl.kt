package com.meek.notely.notes.data.db

import com.meek.notely.di.IoDispatcher
import com.meek.notely.notes.data.db.notes.NoteDao
import com.meek.notely.notes.data.db.notes.toNote
import com.meek.notely.notes.data.db.notes.toNoteEntity
import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.domain.models.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val noteDao: NoteDao,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) : NoteRepository {
    val repositoryScope = CoroutineScope(dispatcher)
    override fun getAllNotes() = noteDao.getAllNotes().map {
        it.map { noteEntity ->
            noteEntity.toNote()
        }
    }

    override fun addNote(note: Note) {
        repositoryScope.launch {
            noteDao.insertNote(note.toNoteEntity())
        }
    }

    override fun deleteNote(noteId: String) {
        repositoryScope.launch {
            noteDao.deleteNote(noteId)
        }
    }

    override fun updateNote(note: Note) {
        repositoryScope.launch {
            noteDao.upsertNote(note.toNoteEntity())
        }
    }
}