package com.meek.notely.notes.domain.usecases

import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.domain.models.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    val noteRepository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}