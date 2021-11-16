package com.example.marvelapp.view.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.logic.manager.SharedPreferencesManager
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.comics.PreviewComic
import com.example.marvelapp.repository.ComicRepository
import com.example.marvelapp.viewmodel.ComicsViewModel
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class ComicsAdapter(val arrayList: List<PreviewComic>, val context: Context): RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {
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
        var description : TextView = binding.findViewById(R.id.comic_description)
        var pagesCount : TextView = binding.findViewById(R.id.comic_pages_count)
        var comicFavBtn : ImageButton = binding.findViewById(R.id.comic_fav_button)

        fun bind(comic: PreviewComic){
            name.text = comic.title
            description.text = comic.getSmallDesc()
            pagesCount.text = comic.getPageCount()

            val builder = Picasso.Builder(context)
            builder.downloader(OkHttp3Downloader(context))

            var manager = SharedPreferencesManager.getInstance(context)
            val id = "${comic.id}"
            comicFavBtn.setOnClickListener {
                if (manager.isFav(id)){
                    manager.remove(id)
                    comicFavBtn.setImageResource(R.drawable.ic_outline_star)
                }
                else {
                    ComicRepository.comics.forEach {
                        if (it.id == comic.id){
                            manager.save(id, it)
                            comicFavBtn.setImageResource(R.drawable.ic_star)
                        }
                    }
                }
            }

            if (manager.isFav(id)){
                comicFavBtn.setImageResource(R.drawable.ic_star)
            }
            else {
                comicFavBtn.setImageResource(R.drawable.ic_outline_star)
            }

            builder.build().load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
                .placeholder(R.drawable.ic_comic)
                .error(R.drawable.ic_image_error)
                .into(thumbnail)
        }

    }

}