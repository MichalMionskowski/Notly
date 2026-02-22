package com.meek.notely.di

import android.content.Context
import androidx.room.Room
import com.meek.notely.notes.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "notely_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: AppDatabase) = database.noteDao()
}