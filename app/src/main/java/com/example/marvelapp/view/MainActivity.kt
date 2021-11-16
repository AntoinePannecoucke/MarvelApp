package com.example.marvelapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapp.R
import com.example.marvelapp.view.fragments.ComicsFragment
import com.example.marvelapp.view.fragments.FavoriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    var navBar : BottomNavigationView? = null
    private var selectedTab = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navBar = this.findViewById(R.id.bottom_nav_bar)
        navBar?.itemIconTintList = null
        initNav()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, ComicsFragment()).commit()
    }

    fun initNav(){
        navBar?.setOnItemSelectedListener {
            if (selectedTab != it.itemId) {
                selectedTab = it.itemId
                when (it.itemId) {
                    R.id.comic_nav_btn -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, ComicsFragment()).commit()
                        true
                    }
                    R.id.favorite_nav_btn -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, FavoriteFragment()).commit()
                        true
                    }
                    R.id.search_nav_btn -> {
                        true
                    }
                    else -> false
                }
            }
            false

        }

    }
}