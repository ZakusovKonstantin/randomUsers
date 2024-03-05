package com.example.randomusers.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.randomusers.UserViewModel
import com.example.randomusers.ui.theme.UserScreen

@Composable
fun UserNavApp(userViewModel: UserViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = UserScreen.StartList.name
    ) {
        composable(UserScreen.StartList.name) {
            HomeScreen(
                userUiState = userViewModel.userUiState,
                navController = navController,
                userViewModel
            )
        }
        composable(UserScreen.DetailList.name) {
            UserDetail(userViewModel)
        }
    }
}