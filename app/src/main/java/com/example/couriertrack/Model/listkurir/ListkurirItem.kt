package com.example.couriertrack.Model.listkurir


import com.google.gson.annotations.SerializedName

class ListkurirItem(
    @SerializedName("code")
    var code: String,
    @SerializedName("description")
    var description: String
)