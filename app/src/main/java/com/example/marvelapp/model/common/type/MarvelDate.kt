package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName

data class MarvelDate(
    @SerializedName("type") val type: String,
    @SerializedName("date") val date: String,
)
