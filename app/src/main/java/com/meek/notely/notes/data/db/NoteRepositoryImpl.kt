package com.meek.notely.notes.data.db

import com.meek.notely.notes.data.db.notes.NoteDao
import com.meek.notely.notes.data.db.notes.toNote
import com.meek.notely.notes.data.db.notes.toNoteEntity
import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.domain.models.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val noteDao: NoteDao
): NoteRepository {
    override fun getAllNotes() = noteDao.getAllNotes().map {
        it.map { noteEntity ->
            noteEntity.toNote()
        }
    }

    override fun addNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insertNote(note.toNoteEntity())
        }
    }
}