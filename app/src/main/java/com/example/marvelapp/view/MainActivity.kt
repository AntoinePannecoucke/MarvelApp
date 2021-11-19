package com.example.marvelapp.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.marvelapp.R
import com.example.marvelapp.view.fragments.ComicsFragment
import com.example.marvelapp.view.fragments.FavoriteFragment
import com.example.marvelapp.view.fragments.ScanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    var navBar : BottomNavigationView? = null
    private var selectedTab = 0

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 42)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkCameraPermission()
        setContentView(R.layout.activity_main)
        navBar = this.findViewById(R.id.bottom_nav_bar)
        initNav()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ComicsFragment()).commit()
    }

    fun initNav(){
        navBar?.setOnItemSelectedListener {
            if (selectedTab != it.itemId) {
                selectedTab = it.itemId
                when (it.itemId) {
                    R.id.comic_nav_btn -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, ComicsFragment()).commit()

                    }
                    R.id.favorite_nav_btn -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, FavoriteFragment()).commit()

                    }
                    R.id.search_nav_btn -> {
                        supportFragmentManager.beginTransaction()
                           .replace(R.id.fragmentContainerView, ScanFragment()).commit()

                    }
                }
            }
            true

        }

    }
}