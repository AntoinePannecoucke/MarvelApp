package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelDate(
    @SerializedName("type") val type: String,
    @SerializedName("date") val date: String,
) : Serializable
