package com.example.couriertrack.Model.cekresi

import com.google.gson.annotations.SerializedName


data class History(
    @SerializedName("date")
    var date: String,
    @SerializedName("desc")
    var desc: String,
    @SerializedName("location")
    var location: String
)