package com.example.couriertrack.Model.listkurir

import com.example.couriertrack.Model.builder.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface Getlistkurir {
    @GET("list_courier")
    suspend fun getlistcourirer(
        @Query("api_key") api_key : String = Constant.api_key
    ): Response<Listkurir>
}