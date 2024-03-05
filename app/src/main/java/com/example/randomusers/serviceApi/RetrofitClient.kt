package com.example.randomusers.serviceApi

import com.example.randomusers.modelApi.RandomUserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://randomuser.me/"

private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface ApiService {
    @GET("api")
    suspend fun getUsers(@Query("results") results: String): Response<RandomUserResponse>
}

object UserApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


