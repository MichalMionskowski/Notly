package com.meek.notely.notes.domain.usecases

import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.domain.models.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    val noteRepository: NoteRepository
) {
    operator fun invoke(note: Note) {
        noteRepository.addNote(note)
    }
}