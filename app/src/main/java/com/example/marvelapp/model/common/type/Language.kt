package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Language(
    @SerializedName("type") val type: String,
    @SerializedName("language") val language: String,
    @SerializedName("text") val text: String
) : Serializable
