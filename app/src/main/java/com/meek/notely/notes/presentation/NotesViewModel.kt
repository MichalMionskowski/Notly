package com.meek.notely.notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meek.notely.notes.domain.AddNoteUseCase
import com.meek.notely.notes.domain.DeleteNoteUseCase
import com.meek.notely.notes.domain.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    getAllNotesUseCase: GetAllNotesUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val notesUiMapper: NotesUiMapper,
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
        }
    }
}