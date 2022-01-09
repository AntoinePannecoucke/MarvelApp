package com.example.marvelapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.repository.ComicRepository
import kotlinx.coroutines.launch

class ScanFragmentViewModel : ViewModel() {

    var comic : MutableLiveData<Comic>? = null

    fun loadScannedQRCode(id : Int) : LiveData<Comic> {
        comic = MutableLiveData<Comic>()
        viewModelScope.launch {
            val result = ComicRepository.getComic(id)
            comic!!.postValue(result)
        }
        return comic!!
    }
}