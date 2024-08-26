package com.marcossalto.emailapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marcossalto.emailapp.core.Constants.Companion.EMAIL_TABLE

@Entity(tableName = EMAIL_TABLE)
data class Email(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val sender: String,
    val subject: String,
    val body: String,
    @ColumnInfo(name = "delivery_time") val deliveryTime: String,
    @ColumnInfo(name = "is_unread") val isUnread: Boolean,
    @ColumnInfo(name = "is_starred") val isStarred: Boolean
)
