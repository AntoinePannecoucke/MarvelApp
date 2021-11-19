package com.example.marvelapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.comics.PreviewComic
import com.example.marvelapp.view.adapters.TwoImageAdapter
import com.example.marvelapp.viewmodel.ComicDetailViewModel
import com.squareup.picasso.Picasso

class ComicDetailsActivity : AppCompatActivity() {
    var vm : ComicDetailViewModel? = null


    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_comic_details)
        vm = ComicDetailViewModel(intent.getSerializableExtra("comic") as PreviewComic?)

        val recyclerView = findViewById<RecyclerView>(R.id.comic_detail_image_list).also{
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = TwoImageAdapter(vm?.getThumbnailsList(), this)
        }

        recyclerView?.layoutManager
        findViewById<TextView>(R.id.comic_detail_title).text = vm?.comic?.title
        findViewById<TextView>(R.id.comic_detail_description).text = vm?.comic?.description
        Log.d("Picasso", "${vm?.comic?.thumbnail?.path}${vm?.comic?.thumbnail?.extension}")
        Picasso.with(this.baseContext).load("${vm?.comic?.thumbnail?.path}.${vm?.comic?.thumbnail?.extension}")
            .placeholder(R.drawable.ic_image_placeholder)
            .into(findViewById<ImageView>(R.id.comic_detail_thumbnail))

    }
}