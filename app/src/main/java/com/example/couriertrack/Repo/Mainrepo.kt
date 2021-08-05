package com.example.couriertrack.Repo

import com.example.couriertrack.API.*
import com.example.couriertrack.API.Data
import com.example.couriertrack.Module.AppModule
import retrofit2.Response
import java.math.BigInteger
import java.security.Key

class Mainrepo {
    //get api data : data,message,status
    suspend fun getsum(key : String,courier: String,resi: Long): Response<Summary>{
        return AppModule.api.getSummary(key,courier,resi)
    }

    suspend fun gethistory(keysum: String,courier: String,resi: Long): Response<History>{
        return AppModule.api.getHistory(keysum,courier,resi)
    }
}