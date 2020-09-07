package com.benmohammad.reelzapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    const val BASE_URL = "https://api.jdoodle.com/v1/";
    const val API_ID = "773eca4179a8c20e92caa73a5dacffda"
    const val API_SECRET =
        "707335836b501dd67fceb6b4c71b08ad91d1698dd90ea769e22d8531b7e0b780"
    const val LANGUAGE = "java"
    const val VERSION_INDEX = "0"


    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java);
}