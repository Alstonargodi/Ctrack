package com.example.couriertrack.Viewmodel.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.couriertrack.Model.room.database.residatabase
import com.example.couriertrack.Model.room.entity.Resi
import com.example.couriertrack.Repo.Room.Resirepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class resiviewmodel(application: Application) : AndroidViewModel(application){
    val readresi : LiveData<List<Resi>>
    private val repo : Resirepo

    init {
        val residao = residatabase.getdatabase(application).residao()
        repo = Resirepo(residao)
        readresi = repo.readresi
    }

    fun add(resi: Resi){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addresi(resi)
        }
    }
}