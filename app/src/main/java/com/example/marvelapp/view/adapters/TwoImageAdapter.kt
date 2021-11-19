package com.example.marvelapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.common.Thumbnail
import com.squareup.picasso.Picasso

class TwoImageAdapter(val list: List<List<Thumbnail?>>?, val context: Context ) : RecyclerView.Adapter<TwoImageAdapter.ThreeImageViewHolder>() {

    inner class ThreeImageViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding){
        val firstImageView = binding.findViewById<ImageView>(R.id.first_image)
        val secondImageView = binding.findViewById<ImageView>(R.id.second_image)


        fun bind(list: List<Thumbnail?>?) {
            if (list != null){
                if (list[0] != null){
                    Picasso.with(context).load("${list[0]?.path}.${list[0]?.extension}")
                            .placeholder(R.drawable.ic_image_placeholder)
                            .into(firstImageView)
                }
                else {
                    firstImageView.isVisible = false
                }
                if (list[1] != null){
                    Picasso.with(context).load("${list[0]?.path}.${list[0]?.extension}")
                        .placeholder(R.drawable.ic_image_placeholder)
                        .into(secondImageView)
                }
                else {
                    secondImageView.isVisible = false
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeImageViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.comic_images_item,parent,false)
        return ThreeImageViewHolder(root)
    }

    override fun onBindViewHolder(holder: ThreeImageViewHolder, position: Int) {
        holder.bind(list?.get(position))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}