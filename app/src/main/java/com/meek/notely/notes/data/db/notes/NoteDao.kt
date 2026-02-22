package com.meek.notely.notes.data.db.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes(): List<Note>
}