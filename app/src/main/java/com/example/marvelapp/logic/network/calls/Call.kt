package com.example.marvelapp.logic.network.calls

interface Call<out T> {
    suspend fun execute(): Result<T>
}