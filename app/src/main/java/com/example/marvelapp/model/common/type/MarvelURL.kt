package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelURL(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
) : Serializable
