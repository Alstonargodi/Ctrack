package com.example.couriertrack.Viewmodel.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.couriertrack.Repo.api.Mainrepo

class Vmfactory(private val mainrepo: Mainrepo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Viewmodelapi(mainrepo) as T
    }
}