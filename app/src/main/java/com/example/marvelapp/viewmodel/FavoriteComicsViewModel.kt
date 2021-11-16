package com.example.marvelapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.logic.manager.SharedPreferencesManager
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.comics.PreviewComic
import okhttp3.internal.notify
import java.util.*

class FavoriteComicsViewModel(private val context: Context) : ViewModel() {

    fun getFav() : LiveData<List<PreviewComic>?>{
        val favorites =  MutableLiveData<List<PreviewComic>?>()
        val manager = SharedPreferencesManager.getInstance(this.context)
        val result = manager.getAll()
        val list = List(result.size) { index ->
            val item = result[index]
            PreviewComic(item.id, item.title, item.description, item.pageCount, item.thumbnail, item.images)
        }
        favorites.postValue(list)

        return favorites
    }
    
}