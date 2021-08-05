package com.example.couriertrack.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.couriertrack.room.Find
import com.example.couriertrack.room.findDao

class Roomrepo(private val findDao: findDao) {
        val readhistory : LiveData<List<Find>> = findDao.readhistory()

    fun addhistory(find: Find){
        findDao.addhistory(find)
    }

    fun deletehistory(find: Find){
        findDao.deletehisory(find)
    }


}