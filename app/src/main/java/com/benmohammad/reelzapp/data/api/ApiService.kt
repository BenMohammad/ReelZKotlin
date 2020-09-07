package com.benmohammad.reelzapp.data.api

import com.benmohammad.reelzapp.data.model.PostData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("execute")
    @Headers("Content-type: application/json")
    fun fetchCompilation(@Body postData: PostData): Call<String>
    fun fetchCompilation(@Field("clientId") clientId: String, @Field("clientSecret") clientSecret: String,
                @Field("script") script: String, @Field("language") language: String,
                @Field("versionIndex") versionIndex: String
                ): String
}