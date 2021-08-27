package com.example.couriertrack.Repo.Room

import androidx.lifecycle.LiveData
import com.example.couriertrack.Model.room.entity.Find
import com.example.couriertrack.Model.room.dao.findDao

class Roomrepo(private val findDao: findDao) {
    val readhistory : LiveData<List<Find>> = findDao.readhistory()

    fun addhistory(find: Find){
        findDao.addhistory(find)
    }

}