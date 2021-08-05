package com.example.couriertrack.API

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response
import retrofit2.http.Query
import java.math.BigInteger

interface GetApi {
   @GET("v1/track/")
   suspend fun getSummary(
      @Query("api_key")
      apikey : String,
      @Query("courier")
      kurir : String,
      @Query("awb")
      awb : Long
   ): Response<Summary>

   @GET("v1/track/")
   suspend fun getHistory(
      @Query("api_key")
      apikey : String,
      @Query("courier")
      kurir : String,
      @Query("awb")
      awb : Long
   ): Response<History>
}