package com.example.couriertrack.Model.cekongkir


import com.google.gson.annotations.SerializedName

class Status(
    @SerializedName("code")
    var code: Int,
    @SerializedName("description")
    var description: String
)