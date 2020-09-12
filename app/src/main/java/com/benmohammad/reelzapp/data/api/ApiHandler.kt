package com.benmohammad.reelzapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiHandler {

    private val BASE_URL = "https://api.jdoodle.com/v1/"
    private val BASE_URL_CREDIT = "https://api.jdoodle.com/v1/"
    var retroFit: Retrofit? = null

    const val API_ID = "API_KEY"
    const val API_SECRET =
        "72a5c9b7faf9f79790250fa2283ff7ca525af24710326a9e6679f32be5a4be41"
    const val LANGUAGE = "java"
    const val VERSION_INDEX = "0"

    fun getService(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        if(retroFit == null) {
            retroFit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()

        }
        return retroFit!!.create(ApiService::class.java)
    }


    fun getServiceForCreditUsed(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        if(retroFit == null) {
            retroFit = Retrofit.Builder()
                .baseUrl(BASE_URL_CREDIT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
        }
        return retroFit!!.create(ApiService::class.java)
    }

}