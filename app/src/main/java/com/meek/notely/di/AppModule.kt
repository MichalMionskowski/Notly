package com.meek.notely.di

import com.meek.notely.notes.data.db.NoteRepositoryImpl
import com.meek.notely.notes.domain.NoteRepository
import com.meek.notely.notes.presentation.notes.NotesUiMapper
import com.meek.notely.notes.presentation.notes.NotesUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Bindings {
        @Binds
        @Singleton
        fun bindNoteRepository(
            noteRepositoryImpl: NoteRepositoryImpl
        ): NoteRepository

        @Binds
        @Singleton
        fun bindNotesUiMapper(
            notesUiMapperImpl: NotesUiMapperImpl
        ): NotesUiMapper

    }



}

