package com.meek.notely.notes.domain.usecases

import com.meek.notely.notes.domain.NoteRepository
import javax.inject.Inject

class GetNoteDetailsUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(noteId: String) = noteRepository.getNoteDetailsById(noteId)
}