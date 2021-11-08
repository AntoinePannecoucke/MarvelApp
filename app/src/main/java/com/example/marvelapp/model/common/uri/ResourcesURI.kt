package com.example.marvelapp.model.common.uri

import com.google.gson.annotations.SerializedName

data class ResourcesURI(
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String,
    @SerializedName("role") val role: String?,
    @SerializedName("type") val type: String?
)
