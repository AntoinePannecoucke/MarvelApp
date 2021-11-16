package com.example.marvelapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.logic.manager.SharedPreferencesManager
import com.example.marvelapp.model.comics.PreviewComic
import com.example.marvelapp.repository.ComicRepository
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class FavoriteAdapter(val arrayList: List<PreviewComic>, val context: Context): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
        ): FavoriteAdapter.FavoriteViewHolder {
            val root = LayoutInflater.from(parent.context).inflate(R.layout.comic_item,parent,false)
            return FavoriteViewHolder(root)
        }

        override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
            holder.bind(arrayList[position])
        }

        override fun getItemCount(): Int {
            if(arrayList.isEmpty()){
                Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
            }
            return arrayList.size
        }

        inner class FavoriteViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

            var name : TextView = binding.findViewById(R.id.comic_name)
            var thumbnail : ImageView = binding.findViewById(R.id.comic_image)
            var description : TextView = binding.findViewById(R.id.comic_description)
            var pagesCount : TextView = binding.findViewById(R.id.comic_pages_count)
            var comicFavBtn : ImageButton = binding.findViewById(R.id.comic_fav_button)

            fun bind(comic: PreviewComic){
                name.text = comic.title
                description.text = comic.getSmallDesc()
                pagesCount.text = comic.getPageCount()

                val builder = Picasso.Builder(context)
                builder.downloader(OkHttp3Downloader(context))

                comicFavBtn.isEnabled = false
                comicFavBtn.isVisible = false

                builder.build().load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                    .placeholder(R.drawable.ic_comic)
                    .error(R.drawable.ic_image_error)
                    .into(thumbnail)
            }

        }
}