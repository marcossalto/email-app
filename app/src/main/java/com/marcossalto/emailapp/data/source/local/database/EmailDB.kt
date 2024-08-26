package com.marcossalto.emailapp.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcossalto.emailapp.data.source.local.dao.EmailDao
import com.marcossalto.emailapp.domain.model.Email

@Database(
    entities = [Email::class],
    version = 1,
    exportSchema = false
)
abstract class EmailDB: RoomDatabase() {
    abstract val emailDao: EmailDao
}
