package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName

data class TypePrice(
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Float,
)
