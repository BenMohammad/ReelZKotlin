package com.benmohammad.reelzapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHandler {

    private val BASE_URL = "https://api.jdoodle.com/v1/"


    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}