package com.example.randomusers.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class], version = 1
)
abstract class DataBaseUsers : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var Instance: DataBaseUsers? = null

        fun createDataBase(context: Context): DataBaseUsers {

            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DataBaseUsers::class.java,
                    "DataBaseUsers"
                ).build()
                    .also { Instance = it }
            }
        }
    }
}