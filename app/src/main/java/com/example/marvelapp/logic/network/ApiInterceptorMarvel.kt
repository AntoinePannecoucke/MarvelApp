package com.example.marvelapp.logic.network

import com.example.marvelapp.logic.manager.ResourcesManager
import com.example.marvelapp.usecase.md5.GetMD5UseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.time.LocalDateTime


class ApiInterceptorMarvel : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val timestamp = LocalDateTime.now().toString()

        val hash =
            runBlocking { GetMD5UseCase(timestamp + ResourcesManager.privateKey + ResourcesManager.publicKey).execute() }

        requestBuilder.url(
            chain.request().url.newBuilder()
                .addQueryParameter("ts", timestamp)
                .addQueryParameter("apikey", ResourcesManager.publicKey)
                .addQueryParameter("hash", hash.getOrNull())
                .toString()
        )

        return chain.proceed(requestBuilder.build())
    }
}