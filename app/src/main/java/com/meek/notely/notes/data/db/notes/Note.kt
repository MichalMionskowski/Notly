package com.meek.notely.notes.data.db.notes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val id: String,
    val completed: Boolean,
    val content: String
)