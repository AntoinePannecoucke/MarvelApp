package com.example.marvelapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.logic.network.calls.get.GetAllComics
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.comics.PreviewComic
import com.example.marvelapp.model.common.ApiResponse
import com.example.marvelapp.repository.ComicRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    fun getComics() : LiveData<List<PreviewComic>?> {
        val comics = MutableLiveData<List<PreviewComic>?>()
        viewModelScope.launch {
            val result = ComicRepository.getComics()
            if (result != null){
                val list = List<PreviewComic>(result.size) { index ->
                    val item = result[index]
                    PreviewComic(item.id, item.title, item.description, item.pageCount, item.thumbnail)
                }
                comics.postValue(list)
            }
        }
        return comics
    }
}