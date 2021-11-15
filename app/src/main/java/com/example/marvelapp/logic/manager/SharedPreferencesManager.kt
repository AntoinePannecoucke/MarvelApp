package com.example.marvelapp.logic.manager

import android.content.Context
import android.content.SharedPreferences
import com.example.marvelapp.model.comics.Comic
import com.google.gson.Gson

class SharedPreferencesManager(val context: Context) {
    //TODO faire un companion object pour récuperer la même instance partout
    private val FAV_COMICS = "favorite_comics"
    val sharedPref: SharedPreferences = context.getSharedPreferences(FAV_COMICS, Context.MODE_PRIVATE)

    fun save(comicId: String, value: Comic) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(comicId, Gson().toJson(value))
        editor.apply()
    }

    fun getValue(comicId: String) : Comic? {
        sharedPref.getString(comicId,null)?.let {
            return Gson().fromJson(it, Comic::class.java)
        }
        return null
    }

    companion object {
        private var instance : SharedPreferencesManager? = null
        fun getInstance(context: Context) : SharedPreferencesManager {
            if (instance == null){
                instance = SharedPreferencesManager(context)
            }
            return instance!!
        }
    }
}