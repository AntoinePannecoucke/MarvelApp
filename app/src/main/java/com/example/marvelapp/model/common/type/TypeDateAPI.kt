package com.example.marvelapp.model.common.type

import com.google.gson.annotations.SerializedName

data class TypeDateAPI(
    @SerializedName("type") val type: String,
    @SerializedName("date") val date: String,
)
