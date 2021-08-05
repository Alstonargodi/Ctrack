package com.example.couriertrack.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.couriertrack.Repo.Roomrepo
import com.example.couriertrack.room.Find
import com.example.couriertrack.room.findDatabase
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

    fun deletehistory(find: Find){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deletehistory(find)
        }
    }
}