package com.example.couriertrack.Model.cekresi


import com.google.gson.annotations.SerializedName


data class Api(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Int
)