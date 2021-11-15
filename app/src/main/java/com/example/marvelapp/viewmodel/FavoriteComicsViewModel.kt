package com.example.marvelapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.logic.manager.SharedPreferencesManager
import com.example.marvelapp.model.comics.Comic
import java.util.*

class FavoriteComicsViewModel(var context: Context) : ViewModel() {
    var favorites =  MutableLiveData<ArrayList<Comic>?>()

    fun addToFavorite(comic: Comic){
        SharedPreferencesManager.getInstance(this.context).save("${comic.id}", comic)
    }

    
}