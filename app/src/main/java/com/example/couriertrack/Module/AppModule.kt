package com.example.couriertrack.Module

import com.example.couriertrack.API.GetApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val base_url = "https://api.binderbyte.com/v1/"
object AppModule {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    val api : GetApi by lazy {
        retrofit.create(GetApi::class.java)
    }


}