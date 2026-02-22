package com.meek.notely.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meek.notely.notes.data.db.notes.NoteEntity
import com.meek.notely.notes.data.db.notes.NoteDao

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}
