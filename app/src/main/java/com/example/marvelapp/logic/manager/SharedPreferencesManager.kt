package com.example.marvelapp.logic.manager

import android.content.Context
import android.content.SharedPreferences
import com.example.marvelapp.model.comics.Comic
import com.google.gson.Gson
import java.util.ArrayList

class SharedPreferencesManager(val context: Context) {
    private val FAV_COMICS = "favorite_comics"
    private val sharedPref: SharedPreferences = context.getSharedPreferences(FAV_COMICS, Context.MODE_PRIVATE)

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

    fun isFav(comicId: String) : Boolean {
        return getValue(comicId) != null
    }

    fun remove(comicId: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        if (isFav(comicId)) {
            editor.remove(comicId)
            editor.apply()
        }
    }

    fun getAll() : List<Comic>{
        var list = sharedPref.all.values
        var comics = ArrayList<Comic>()
        list.forEach {
            val tmp : String = it.toString()
            comics.add(Gson().fromJson(tmp, Comic::class.java))
        }
        return comics
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