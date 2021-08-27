package com.example.couriertrack.Model.builder

import com.example.couriertrack.Model.builder.Constant.baseurl
import com.example.couriertrack.Model.cekresi.GetApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object retrofitbuilder {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    val api : GetApi by lazy {
        retrofit.create(GetApi::class.java)
    }


}