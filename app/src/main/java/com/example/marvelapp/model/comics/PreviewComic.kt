package com.example.marvelapp.model.comics

import com.example.marvelapp.model.common.Thumbnail

class PreviewComic(val id: Int, val title: String, private val description: String?, private val pageCount: Int, val thumbnail: Thumbnail) {
    fun getPageCount() : String {
        return "$pageCount pages"
    }

    fun getSmallDesc() : String {
        if (description != null){
            return if (description.length > 100)  "${description.substring( 0, 100)}..." else description
        }
        return ""
    }

}