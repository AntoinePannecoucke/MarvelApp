package com.example.marvelapp.viewmodel

import com.example.marvelapp.model.comics.PreviewComic
import com.example.marvelapp.model.common.Thumbnail
import java.util.ArrayList

class ComicDetailViewModel(val comic:PreviewComic?) {

    fun getThumbnailsList() : List<List<Thumbnail?>> {
        val result = ArrayList<ArrayList<Thumbnail?>>()
        if (comic?.images != null) {
            for (i in 0..comic.images.size step 3) {
                val tmp = ArrayList<Thumbnail?>()
                for (j in 0..2){
                    if (i+j < comic.images.size){
                        tmp.add(comic.images[i])
                    }
                    else {
                        tmp.add(null)
                    }
                }
                result.add(tmp)
            }
        }
        return result
    }
}