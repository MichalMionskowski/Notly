package com.meek.notely.notes.domain

import com.meek.notely.notes.domain.models.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    val noteRepository: NoteRepository
) {
    operator fun invoke(note: Note) {
        noteRepository.addNote(note)
    }
}