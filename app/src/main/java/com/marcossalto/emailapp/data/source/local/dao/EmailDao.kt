package com.marcossalto.emailapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marcossalto.emailapp.core.Constants.Companion.EMAIL_TABLE
import com.marcossalto.emailapp.domain.model.Email

@Dao
interface EmailDao {
    @Insert( onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmail(email: Email)

    @Delete
    suspend fun deleteEmail(email: Email)

    @Query("SELECT * FROM $EMAIL_TABLE WHERE id = :id")
    suspend fun getEmailById(id: Int): Email?

    @Query("SELECT * FROM $EMAIL_TABLE")
    suspend fun getAllEmails(): List<Email>
}
