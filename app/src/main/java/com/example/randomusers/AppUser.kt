package com.example.randomusers

import android.app.Application
import com.example.randomusers.dataBase.DataBaseUsers

class AppUser : Application() {

    val db by lazy { DataBaseUsers.createDataBase(this) }



}