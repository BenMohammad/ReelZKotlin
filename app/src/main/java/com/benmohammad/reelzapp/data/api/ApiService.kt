package com.benmohammad.reelzapp.data.api

import com.benmohammad.reelzapp.data.model.PostData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("execute")
    @Headers("Content-Type: application/json")
    fun execute(@Body postData: PostData?): Call<String>
    @POST("execute")
    @Headers("Content-Type: application/json")
    fun execute(
        @Field("clientId") clientId: String,
        @Field("clientSecret") clientSecret: String,
        @Field("script") script: String,
        @Field("language") language: String,
        @Field("versionIndex") versionIndex: String
    ): Call<String>




}