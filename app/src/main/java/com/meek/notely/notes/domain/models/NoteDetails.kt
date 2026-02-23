package com.meek.notely.notes.domain.models


data class NoteDetail(
    val id: String,
    val completed: Boolean,
    val content: String,
    val description: String,
    val color: ULong,
    val createdAt: String,
)