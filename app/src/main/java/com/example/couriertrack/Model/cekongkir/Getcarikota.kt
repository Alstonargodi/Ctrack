package com.example.couriertrack.Model.cekongkir

import com.example.couriertrack.Model.builder.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//https://api.rajaongkir.com/starter/city?id&key=e41d4ddc6d7b9ce55e37ea43aba3e37d

interface Getcarikota {
    @GET("city?id")
    suspend fun getCity(
        @Query("key") apikey : String = Constant.oApi_key
    ): Response<Carikota>
}