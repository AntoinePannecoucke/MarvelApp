package com.example.marvelapp.logic.network

import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.model.common.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {

    //Comics
    @GET("/v1/public/comics/{id}")
    suspend fun getComic(
        @Path("id") id: Int,
    ): Response<ApiResponse<Comics>>

    @GET("/v1/public/comics")
    suspend fun getAllComics(): Response<ApiResponse<Comics>>


    @GET("/v1/public/comics")
    suspend fun getComicByName(
        @Query("titleStartsWith") titleStartsWith: String,
    ): Response<ApiResponse<Comics>>

    @GET("/v1/public/comics/{id}/creators")
    suspend fun getComicsCreator(
        @Path("id") id: String,
    ): Response<ApiResponse<Comics>>

}