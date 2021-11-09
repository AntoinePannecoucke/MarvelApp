package com.example.marvelapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.viewmodel.ComicsViewModel

class ComicsAdapter(val viewModel: ComicsViewModel, val arrayList: List<Comics>, val context: Context): RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {
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

        fun bind(comic: Comics){
            name.text = comic.title

        }

    }

}