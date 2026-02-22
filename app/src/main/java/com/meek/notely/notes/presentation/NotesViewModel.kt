package com.meek.notely.notes.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(
        NotesState()
    )
    val state = _state.asStateFlow()

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.OnAddNote -> {
                val currentNotes = _state.value.notes
                val updatedNotes = currentNotes + event.note
                _state.value = _state.value.copy(notes = updatedNotes)
            }
        }
    }

}