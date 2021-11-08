package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName

data class TypeURL(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
)
