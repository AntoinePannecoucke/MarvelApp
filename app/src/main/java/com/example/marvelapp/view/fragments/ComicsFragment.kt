package com.example.marvelapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.view.adapters.ComicsAdapter
import com.example.marvelapp.viewmodel.ComicsViewModel

class ComicsFragment : Fragment() {

    var vm = ComicsViewModel()

    private lateinit var recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view = view.findViewById<RecyclerView>(R.id.comics_recyclerview).apply {
            this.layoutManager = LinearLayoutManager(activity)
        }
        vm.getComics().observe(viewLifecycleOwner, { data ->
            recycler_view.adapter = context?.let { data?.let { list -> ComicsAdapter(vm, list, it) } }
        })
    }

}