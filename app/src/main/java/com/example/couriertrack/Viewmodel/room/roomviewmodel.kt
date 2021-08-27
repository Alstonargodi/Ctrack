package com.example.couriertrack.Viewmodel.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.couriertrack.Repo.Room.Roomrepo
import com.example.couriertrack.Model.room.entity.Find
import com.example.couriertrack.Model.room.database.findDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class roomviewmodel(application : Application): AndroidViewModel(application) {
    val readhistory : LiveData<List<Find>>
    private val repo : Roomrepo

    init {
        val finddao = findDatabase.getdatabase(application).findDao()
        repo = Roomrepo(finddao)
        readhistory = repo.readhistory
    }

    fun addhistory(find: Find){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addhistory(find)
        }
    }

}