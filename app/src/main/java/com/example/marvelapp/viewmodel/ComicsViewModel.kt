package com.example.marvelapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.logic.network.calls.get.GetAllComics
import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.model.common.ApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val scope = CoroutineScope(Dispatchers.IO)

class ComicsViewModel : ViewModel() {



    fun getComics() : MutableLiveData<List<Comics>?>{
        var comics = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val jsonResponse = Gson().fromJson<ApiResponse<Comics>>(
                Gson().toJson(GetAllComics().execute().getOrNull()),
                object : TypeToken<ApiResponse<Comics>>() {}.type
            )
            Log.d("Main", "$jsonResponse")
            comics.postValue(jsonResponse.data.results)
        }
        return comics
    }
}