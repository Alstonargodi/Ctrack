package com.example.couriertrack.Model.builder

import com.example.couriertrack.Model.builder.Constant.baseurl
import com.example.couriertrack.Model.builder.Constant.oCarikotabaseurl
import com.example.couriertrack.Model.cekongkir.Getcarikota
import com.example.couriertrack.Model.cekresi.GetApi
import com.example.couriertrack.Model.listkurir.Getlistkurir
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

    val kurir : Getlistkurir by lazy {
        retrofit.create(Getlistkurir::class.java)
    }


    private val retrokota by lazy {
        Retrofit.Builder()
            .baseUrl(oCarikotabaseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getcarikota : Getcarikota by lazy {
        retrokota.create(Getcarikota::class.java)
    }


}