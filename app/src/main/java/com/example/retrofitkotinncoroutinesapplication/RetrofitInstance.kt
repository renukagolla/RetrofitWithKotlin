package com.example.retrofitkotinncoroutinesapplication

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    val Base_URL = "https://jsonplaceholder.typicode.com"

    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

}