package com.example.couriertrack.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.couriertrack.API.Api
import com.example.couriertrack.API.History
import com.example.couriertrack.API.Summary
import com.example.couriertrack.Repo.Mainrepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

//viewmodel fungsi get tracking dari summary dan history
class Viewmodelapi(private val repo: Mainrepo): ViewModel(){
    val summaryrespons : MutableLiveData<Response<Summary>> = MutableLiveData()
    val historyrespons : MutableLiveData<Response<History>> = MutableLiveData()

    fun postsummary(key : String,courier: String,resi: Long){
        viewModelScope.launch{
            val responapi = repo.getsum(key,courier,resi)
            summaryrespons.value = responapi
        }
    }

    fun posthistory(key: String,courier: String,resi: Long){
        viewModelScope.launch {
            val respon = repo.gethistory(key, courier, resi)
            historyrespons.value = respon
        }
    }
}