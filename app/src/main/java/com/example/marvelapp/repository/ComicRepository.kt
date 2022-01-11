package com.example.marvelapp.repository

import android.util.Log
import com.example.marvelapp.logic.network.calls.get.GetAllComics
import com.example.marvelapp.logic.network.calls.get.GetComic
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.common.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

object ComicRepository {

    val comics = ArrayList<Comic>()

    suspend fun getComics() : List<Comic>?{
        try {
            if (comics.isEmpty()) {

                val jsonResponse = Gson().fromJson<ApiResponse<Comic>>(
                    Gson().toJson(GetAllComics().execute().getOrNull()),
                    object : TypeToken<ApiResponse<Comic>>() {}.type
                )
                Log.d("Main", "$jsonResponse")
                if (jsonResponse.code == 200) {
                    comics.addAll(jsonResponse.data.results)
                }
            }
        }
        catch (ex : Exception){
            Log.e("Erreur", ex.message.toString())
        }
        return comics
    }

    suspend fun getComic(id : Int) : Comic? {
        try {
            val jsonResponse = Gson().fromJson<ApiResponse<Comic>>(
                Gson().toJson(GetComic(id).execute().getOrNull()),
                object : TypeToken<ApiResponse<Comic>>() {}.type
            )
            return jsonResponse.data.results[0]
        }
        catch (ex : Exception){
            Log.e("Erreur", ex.message.toString())
        }
        return null
    }

}