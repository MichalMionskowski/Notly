package com.meek.notely.notes.domain.usecases

import com.meek.notely.notes.domain.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    val noteRepository: NoteRepository
) {
    operator fun invoke(noteId: String) {
        noteRepository.deleteNote(noteId)
    }
}