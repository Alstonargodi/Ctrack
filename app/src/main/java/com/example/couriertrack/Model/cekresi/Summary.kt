package com.example.couriertrack.Model.cekresi


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("amount")
    var amount: String,
    @SerializedName("awb")
    var awb: String,
    @SerializedName("courier")
    var courier: String,
    @SerializedName("date")
    var date: String,
    @SerializedName("desc")
    var desc: String,
    @SerializedName("service")
    var service: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("weight")
    var weight: String
)