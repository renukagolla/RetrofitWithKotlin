package com.example.retrofitkotinncoroutinesapplication

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
}