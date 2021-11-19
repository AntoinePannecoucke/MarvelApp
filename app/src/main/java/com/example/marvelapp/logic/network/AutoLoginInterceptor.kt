package com.example.marvelapp.logic.network

import android.util.Log
import com.example.marvelapp.logic.manager.ResourcesManager
import com.example.marvelapp.logic.md5.HashMD5
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.time.LocalDateTime


class AutoLoginInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val timestamp = LocalDateTime.now().toString()

        val hash =
            runBlocking { HashMD5(timestamp + ResourcesManager.privateKey + ResourcesManager.publicKey).execute() }

        Log.d("HASH", hash.getOrThrow())

        requestBuilder.url(
            chain.request().url.newBuilder()
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("apikey", ResourcesManager.publicKey)
                .addQueryParameter("hash", hash.getOrNull())
                .toString()
        )

        Log.d("URL", requestBuilder.toString())

        return chain.proceed(requestBuilder.build())
    }
}