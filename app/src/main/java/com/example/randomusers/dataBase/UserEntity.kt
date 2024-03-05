package com.example.randomusers.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(

    @PrimaryKey(autoGenerate = true) val id: Long,
    val results: String
)

