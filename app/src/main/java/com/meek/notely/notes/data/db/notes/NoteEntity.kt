package com.meek.notely.notes.data.db.notes

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meek.notely.notes.domain.models.Note
import com.meek.notely.notes.domain.models.NoteDetail

@Entity
data class NoteEntity(
    @PrimaryKey val id: String,
    val completed: Boolean,
    val content: String,
    val description: String = "",
    val createdAt: String,
    val color: Long = Color.White.value.toLong()
)


fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        completed = completed,
        content = content)
}

fun NoteEntity.toNoteDetail(): NoteDetail {
    return NoteDetail(
        id = id,
        completed = completed,
        content = content,
        description = description,
        createdAt = createdAt,
        color = color.toULong())
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        completed = completed,
        content = content,
        createdAt = System.currentTimeMillis().toString()
    )
}

