package com.marcossalto.emailapp.di

import android.content.Context
import androidx.room.Room
import com.marcossalto.emailapp.core.Constants.Companion.DATABASE_NAME
import com.marcossalto.emailapp.data.repository.EmailRepositoryImpl
import com.marcossalto.emailapp.data.source.local.database.EmailDB
import com.marcossalto.emailapp.domain.repository.EmailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEmailDB(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        EmailDB::class.java,
        DATABASE_NAME
    )
        .build()

    @Singleton
    @Provides
    fun provideEmailRepository(
        emailDB: EmailDB
    ): EmailRepository =
        EmailRepositoryImpl(emailDB.emailDao())

    @Provides
    @Singleton
    fun provideEmailDao(emailDB: EmailDB) = emailDB.emailDao()
}
