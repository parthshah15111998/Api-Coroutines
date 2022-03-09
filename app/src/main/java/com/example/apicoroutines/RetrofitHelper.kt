package com.example.apicoroutines

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
     const val BASE_URL="https://quotable.io"

    var logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }
}