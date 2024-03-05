package com.example.randomusers

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusers.dataBase.UserDao
import com.example.randomusers.dataBase.UserEntity
import com.example.randomusers.modelApi.User
import com.example.randomusers.serviceApi.UserApi
import com.google.gson.Gson
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {

    var selectedUser: MutableState<User?> = mutableStateOf(null)
    var userUiState: UserUiState by mutableStateOf(UserUiState.Loading)
        private set

    private val gson = Gson()

    init {

        viewModelScope.launch {
            val users = userDao.getAllUsers().map { convertUserEntityToUser(it) }
            userUiState = if (users.isNotEmpty()) {
                UserUiState.Success(users)
            } else {
                try {
                    val response = UserApi.retrofitService.getUsers("100")
                    val apiUsers = response.body()!!.results
                    apiUsers.forEach { user ->
                        userDao.insertUsers(convertUserToUserEntity(user))
                    }
                    UserUiState.Success(apiUsers)
                } catch (e: Exception) {
                    UserUiState.Error
                }
            }
        }
    }

    private fun convertUserEntityToUser(userEntity: UserEntity): User {
        return gson.fromJson(userEntity.results, User::class.java)
    }

    private fun convertUserToUserEntity(user: User): UserEntity {
        return UserEntity(id = 0, results = gson.toJson(user))
    }
}

sealed interface UserUiState {
    data class Success(val users: List<User>) : UserUiState
    data object Error : UserUiState
    data object Loading : UserUiState
}








