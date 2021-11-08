package com.example.marvelapp.model.comics

import com.google.gson.annotations.SerializedName
import com.example.marvelapp.model.common.uri.ListSamples
import com.example.marvelapp.model.common.uri.Sample
import com.example.marvelapp.model.common.Thumbnail
import com.example.marvelapp.model.common.type.MarvelDate
import com.example.marvelapp.model.common.type.Language
import com.example.marvelapp.model.common.type.Price
import com.example.marvelapp.model.common.type.MarvelURL


data class Comics(
    @SerializedName("id") val id: Int,
    @SerializedName("digitalId") val digitalId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("issueNumber") val issueNumber: Double,
    @SerializedName("variantDescription") val variantDescription: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("upc") val upc: String,
    @SerializedName("diamondCode") val diamondCode: String,
    @SerializedName("ean") val ean: String,
    @SerializedName("issn") val issn: String,
    @SerializedName("format") val format: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("textObjects") val textObjects: List<Language>,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<MarvelURL>,
    @SerializedName("series") val series: Sample,
    @SerializedName("variants") val variants: List<Sample>,
    @SerializedName("collections") val collections: List<Sample>,
    @SerializedName("collectedIssues") val collectedIssues: List<Sample>,
    @SerializedName("dates") val dates: List<MarvelDate>,
    @SerializedName("prices") val prices: List<Price>,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("images") val images: List<Thumbnail>,
    @SerializedName("creators") val creators: ListSamples,
    @SerializedName("characters") val characters: ListSamples,
    @SerializedName("stories") val stories: ListSamples,
    @SerializedName("events") val events: ListSamples
)
