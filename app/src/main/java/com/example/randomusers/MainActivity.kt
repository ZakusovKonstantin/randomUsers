package com.example.randomusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.randomusers.presentation.UserNavApp
import com.example.randomusers.ui.theme.RandomUsersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(application) as AppUser).db
                return UserViewModel(database.userDao()) as T
            }
        }

        setContent {

            val viewModel: UserViewModel = viewModel(factory = factory)

            RandomUsersTheme {
                UserNavApp(viewModel)
            }
        }
    }
}








