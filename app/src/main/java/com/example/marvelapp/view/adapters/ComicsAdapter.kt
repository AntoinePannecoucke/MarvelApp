package com.example.marvelapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.viewmodel.ComicsViewModel
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class ComicsAdapter(val viewModel: ComicsViewModel, val arrayList: List<Comic>, val context: Context): RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ComicsAdapter.ComicsViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.comic_item,parent,false)
        return ComicsViewHolder(root)
    }

    override fun onBindViewHolder(holder: ComicsAdapter.ComicsViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        if(arrayList.isEmpty()){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }


    inner class ComicsViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

        var name : TextView = binding.findViewById(R.id.comic_name)
        var thumbnail : ImageView = binding.findViewById(R.id.comic_image)

        fun bind(comic: Comic){
            name.text = comic.title

            val builder = Picasso.Builder(context)
            builder.downloader(OkHttp3Downloader(context))

            builder.build().load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(thumbnail)
        }

    }

}