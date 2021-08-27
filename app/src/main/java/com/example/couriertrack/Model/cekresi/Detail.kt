package com.example.couriertrack.Model.cekresi


import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("destination")
    var destination: String,
    @SerializedName("origin")
    var origin: String,
    @SerializedName("receiver")
    var `receiver`: String,
    @SerializedName("shipper")
    var shipper: String
)