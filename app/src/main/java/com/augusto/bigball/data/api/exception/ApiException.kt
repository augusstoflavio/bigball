package com.augusto.bigball.data.api.exception

import com.augusto.bigball.core.domain.entity.Result
import java.io.IOException

class ApiException(private val messageError: String, private val code: Int): IOException(), ApiError {

    override fun toError(): Result.Error {
        return Result.Error(message = messageError, code = code)
    }
}