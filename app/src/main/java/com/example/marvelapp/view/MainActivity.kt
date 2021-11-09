package com.example.marvelapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.marvelapp.R
import com.example.marvelapp.view.fragments.ComicsFragment
import com.example.marvelapp.viewmodel.ComicsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.findViewById<BottomNavigationView>(R.id.bottom_nav_bar).itemIconTintList = null

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ComicsFragment()).commit()
    }
}