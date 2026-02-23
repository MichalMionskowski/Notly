package com.meek.notely.notes.data.db.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("DELETE FROM NoteEntity WHERE id = :noteId")
    suspend fun deleteNote(noteId: String)

    @Upsert
    suspend fun upsertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity WHERE id = :id")
    fun getNote(id: String): Flow<NoteEntity>

    @Query("SELECT * FROM NoteEntity")
    fun getAllNotes(): Flow<List<NoteEntity>>
}