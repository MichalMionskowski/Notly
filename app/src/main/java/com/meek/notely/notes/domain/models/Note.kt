package com.meek.notely.notes.domain.models

data class Note(
    val id: String,
    val completed: Boolean,
    val content: String
)