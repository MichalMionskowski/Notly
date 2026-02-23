package com.meek.notely.notes.presentation.noteDetail

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.meek.notely.notes.domain.usecases.GetNoteDetailsUseCase
import com.meek.notely.notes.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNoteDetailsUseCase: GetNoteDetailsUseCase
) : ViewModel() {
    private val id = savedStateHandle.toRoute<Screen.NoteScreen>().noteId

    val state: StateFlow<NoteDetailState> = getNoteDetailsUseCase(id).map {
        NoteDetailState.Success(
            NoteDetailItem(
                id = it.id,
                completed = it.completed,
                content = it.content,
                description = it.description,
                color = Color(it.color),
                createdAt = it.createdAt
            )
        )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), NoteDetailState.Loading)
}