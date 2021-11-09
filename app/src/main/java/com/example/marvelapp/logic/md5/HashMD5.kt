package com.example.marvelapp.logic.md5

import java.math.BigInteger
import java.security.MessageDigest

class HashMD5(private val data: String) {

    suspend fun execute(): Result<String> {
        return try {
            val md = MessageDigest.getInstance("MD5")
            md.reset()
            md.update(data.toByteArray())

            return Result.success(BigInteger(1, md.digest()).toString(16).padStart(32, '0'))

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}