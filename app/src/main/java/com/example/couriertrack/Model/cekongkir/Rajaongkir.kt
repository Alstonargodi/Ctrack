package com.example.couriertrack.Model.cekongkir


import com.google.gson.annotations.SerializedName

class Rajaongkir(
    @SerializedName("query")
    var query: Query,
    @SerializedName("results")
    var results: List<Result>,
    @SerializedName("status")
    var status: Status
)