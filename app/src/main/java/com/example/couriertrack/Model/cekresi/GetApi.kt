package com.example.couriertrack.Model.cekresi

import com.example.couriertrack.Model.builder.Constant.api_key
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

/*
   https://api.binderbyte.com/v1/track?api_key=[ ]&courier=jne&awb=8825112045716759
 */
interface GetApi {
   @GET("track")
   suspend fun getSummary(
      @Query("courier") kurir : String,
      @Query("awb") awb : Long,
      @Query("api_key") apikey : String = api_key
   ): Response<Api>
}