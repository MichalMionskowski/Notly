package com.meek.notely.notes.presentation

data class NotesState(
    val notes : List<NoteItem> = emptyList()
)

data class NoteItem(
    val id: String,
    val completed: Boolean,
    val content: String
)


sealed class NotesEvent{
    data class OnAddNote(val note: NoteItem) : NotesEvent()
    data class OnDeleteNote(val noteId: String) : NotesEvent()
}