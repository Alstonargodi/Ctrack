package com.example.couriertrack.Repo.api

import com.example.couriertrack.Model.builder.retrofitbuilder
import com.example.couriertrack.Model.cekongkir.Rajaongkir
import com.example.couriertrack.Model.cekresi.Api
import com.example.couriertrack.Model.cekresi.History
import com.example.couriertrack.Model.cekresi.Summary
import com.example.couriertrack.Model.listkurir.Listkurir
import retrofit2.Response

class Mainrepo {

    //get api data : data,message,status
    suspend fun getsum(apikey: String,courier: String,resi: String): Response<Api>{
        return retrofitbuilder.api.getSummary(apikey,courier,resi)
    }

    suspend fun getlistkurir(apikey: String): Response<Listkurir>{
        return retrofitbuilder.kurir.getlistcourirer(apikey)
    }

    suspend fun getCarikota(apikey: String): Response<com.example.couriertrack.Model.cekongkir.Carikota>{
        return retrofitbuilder.getcarikota.getCity(apikey)
    }

}