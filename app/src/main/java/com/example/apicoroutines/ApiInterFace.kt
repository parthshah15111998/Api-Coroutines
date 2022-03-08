package com.example.apicoroutines

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterFace {

    @GET("/quotes")
    suspend fun getData(@Query("page")page:Int):Response<QuoteList>
}