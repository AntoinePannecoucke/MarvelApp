package com.example.marvelapp.logic.network.calls.get

import com.example.marvelapp.logic.network.RetrofitClient
import com.example.marvelapp.logic.network.calls.Call
import com.example.marvelapp.model.comics.Comic
import com.example.marvelapp.model.common.ApiResponse

class GetComic(private val id: Int) : Call<ApiResponse<Comic>?> {

    override suspend fun execute(): Result<ApiResponse<Comic>?> {
        return try {
            val response = RetrofitClient.RETROFIT_INTERFACE.getComic(id)

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}