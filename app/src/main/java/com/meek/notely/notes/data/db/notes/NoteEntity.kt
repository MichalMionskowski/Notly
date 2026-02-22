package com.meek.notely.notes.data.db.notes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meek.notely.notes.domain.models.Note

@Entity
data class NoteEntity(
    @PrimaryKey val id: String,
    val completed: Boolean,
    val content: String
)


fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        completed = completed,
        content = content)
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        completed = completed,
        content = content
    )
}

