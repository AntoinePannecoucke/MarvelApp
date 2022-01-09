package com.example.marvelapp.repository

import android.util.Log
import com.example.marvelapp.logic.network.calls.get.GetAllComics
import com.example.marvelapp.logic.network.calls.get.GetComic
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.common.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ComicRepository {

    val comics = ArrayList<Comic>()

    suspend fun getComics() : List<Comic>?{
        if (comics.isEmpty()){
            val jsonResponse = Gson().fromJson<ApiResponse<Comic>>(
                Gson().toJson(GetAllComics().execute().getOrNull()),
                object : TypeToken<ApiResponse<Comic>>() {}.type
            )
            Log.d("Main", "$jsonResponse")
            comics.addAll(jsonResponse.data.results)
        }
        return comics
    }

    suspend fun getComic(id : Int) : Comic {
        val jsonResponse = Gson().fromJson<ApiResponse<Comic>>(
            Gson().toJson(GetComic(id).execute().getOrNull()),
            object : TypeToken<ApiResponse<Comic>>() {}.type
        )
        return jsonResponse.data.results[0]
    }

}