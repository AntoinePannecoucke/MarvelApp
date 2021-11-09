package com.example.marvelapp.logic.network.calls.get

import com.example.marvelapp.logic.network.RetrofitClient
import com.example.marvelapp.logic.network.calls.Call
import com.example.marvelapp.model.comics.Comics
import com.example.marvelapp.model.common.ApiResponse

class GetAllComics : Call<ApiResponse<Comics>?> {

    override suspend fun execute(): Result<ApiResponse<Comics>?> {
        return try {
            val response = RetrofitClient.RETROFIT_INTERFACE.getAllComics()

            if (response.isSuccessful && response.body() != null) {
                return Result.success(response.body())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}