package com.meek.notely.notes.domain.usecases

import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.domain.models.Note
import javax.inject.Inject

class SetCompletedTaskUseCase @Inject  constructor(
    val noteRepository: NoteRepository
){

    operator fun invoke(note: Note) {
        noteRepository.updateNote(note)
    }
}