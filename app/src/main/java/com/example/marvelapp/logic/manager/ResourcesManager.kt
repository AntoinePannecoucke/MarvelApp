package com.example.marvelapp.logic.manager

import com.example.marvelapp.BuildConfig;
import java.io.File

object ResourcesManager {
    const val publicKey: String = BuildConfig.marvel_api_public
    const val privateKey: String = BuildConfig.marvel_api_private

    private const val PATH = "src/main/resources/"

    fun loadResource(path: String): String {
        return File(
            PATH,
            path
        ).readText()
    }

}