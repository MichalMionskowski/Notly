package com.meek.notely.notes.presentation.Notes

import com.meek.notely.notes.domain.models.Note
import javax.inject.Inject

interface NotesUiMapper {
    fun mapNoteToNoteItem(note: Note): NoteItem
    fun mapNoteItemToNote(noteItem: NoteItem): Note
}

class NotesUiMapperImpl @Inject constructor() : NotesUiMapper {
    override fun mapNoteToNoteItem(note: Note): NoteItem {
        return NoteItem(
            id = note.id,
            completed = note.completed,
            content = note.content
        )
    }

    override fun mapNoteItemToNote(noteItem: NoteItem): Note {
        return Note(
            id = noteItem.id,
            completed = noteItem.completed,
            content = noteItem.content
        )
    }
}