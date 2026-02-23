package com.meek.notely.notes.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meek.notely.notes.domain.usecases.AddNoteUseCase
import com.meek.notely.notes.domain.usecases.DeleteNoteUseCase
import com.meek.notely.notes.domain.usecases.GetAllNotesUseCase
import com.meek.notely.notes.domain.usecases.SetCompletedTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    val notesUiMapper: NotesUiMapper,
    getAllNotesUseCase: GetAllNotesUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val setCompletedTaskUseCase: SetCompletedTaskUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {
    val state: StateFlow<List<NoteItem>> =
        getAllNotesUseCase().map { domainNotes ->
            domainNotes.map { notesUiMapper.mapNoteToNoteItem(it) }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.OnAddNote -> {
                addNoteUseCase(
                    notesUiMapper.mapNoteItemToNote(
                        event.note
                    )
                )
            }

            is NotesEvent.OnDeleteNote -> {
                deleteNoteUseCase(event.noteId)
            }

            is NotesEvent.OnCheckboxClick -> {
                setCompletedTaskUseCase(
                    notesUiMapper.mapNoteItemToNote(
                        event.note.copy(
                            completed = !event.note.completed
                        )
                    )
                )
            }
        }
    }
}