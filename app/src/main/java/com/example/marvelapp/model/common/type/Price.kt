package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Float,
) : Serializable
