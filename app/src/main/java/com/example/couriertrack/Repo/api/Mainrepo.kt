package com.example.couriertrack.Repo.api

import com.example.couriertrack.Model.builder.retrofitbuilder
import com.example.couriertrack.Model.cekresi.Api
import com.example.couriertrack.Model.cekresi.History
import com.example.couriertrack.Model.cekresi.Summary
import retrofit2.Response

class Mainrepo {
    //get api data : data,message,status
    suspend fun getsum(courier: String,resi: Long): Response<Api>{
        return retrofitbuilder.api.getSummary(courier,resi)
    }

}