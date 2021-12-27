package com.example.couriertrack.Viewmodel.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.couriertrack.Model.cekresi.Api
import com.example.couriertrack.Model.cekresi.History
import com.example.couriertrack.Model.cekresi.Summary
import com.example.couriertrack.Model.listkurir.Listkurir
import com.example.couriertrack.Repo.api.Mainrepo
import kotlinx.coroutines.launch
import retrofit2.Response

//viewmodel fungsi get tracking dari summary dan history
class Viewmodelapi(val repo: Mainrepo): ViewModel(){
    val summaryrespons : MutableLiveData<Response<Api>> = MutableLiveData()
    val listkurirresponse : MutableLiveData<Response<Listkurir>> = MutableLiveData()
    val listkotaresponse : MutableLiveData<Response<com.example.couriertrack.Model.cekongkir.Carikota>> = MutableLiveData()

    fun postsummary(apikey : String,courier: String,resi: String){
        viewModelScope.launch{
            val responapi = repo.getsum(apikey,courier,resi)
            summaryrespons.value = responapi
        }
    }

    fun listkurir(apikey: String){
        viewModelScope.launch {
            val respon = repo.getlistkurir(apikey)
            listkurirresponse.value = respon
        }
    }

    fun getkota(apikey: String){
        viewModelScope.launch {
            val carikotarespon = repo.getCarikota(apikey)
            listkotaresponse.value = carikotarespon
        }
    }

}