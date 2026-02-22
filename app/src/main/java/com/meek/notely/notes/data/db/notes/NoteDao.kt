package com.meek.notely.notes.data.db.notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("DELETE FROM NoteEntity WHERE id = :noteId")
    suspend fun deleteNote(noteId: String)

    @Query("SELECT * FROM NoteEntity")
    fun getAllNotes(): Flow<List<NoteEntity>>
}