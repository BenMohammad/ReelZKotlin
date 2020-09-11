package com.benmohammad.reelzapp.data.api

import com.benmohammad.reelzapp.data.model.PostData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @POST("execute")
    @Headers("Content-Type: application/json")
    fun execute(@Body postData: PostData?): Call<String?>?
}