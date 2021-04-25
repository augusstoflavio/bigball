package com.augusto.bigball.core.domain.entity

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val error: Error) : Result<Nothing>()

    data class Error(
        val message: String,
        val code: Int? = null
    )
}