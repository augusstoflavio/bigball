package com.augusto.bigball.data.api.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.augusto.bigball.core.domain.entity.Result
import com.augusto.bigball.data.api.exception.ApiError

suspend fun <T: Any> safeCall(call: suspend () -> T): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            Result.Success(call.invoke())
        } catch (throwable: Throwable) {
            if (throwable is ApiError) {
                Result.Failure(
                    throwable.toError()
                )
            } else {
                Result.Failure(
                    Result.Error(throwable.message ?: "")
                )
            }
        }
    }
}
