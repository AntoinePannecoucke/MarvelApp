package com.example.marvelapp.viewmodel

import com.example.marvelapp.logic.network.calls.get.GetComics
import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.model.common.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainViewModel {

    suspend fun getComics(): ApiResponse<Comics>? {
        return Gson().fromJson(
            Gson().toJson(GetComics(82967).execute().getOrNull()),
            object : TypeToken<ApiResponse<Comics>>() {}.type
        )
    }
}