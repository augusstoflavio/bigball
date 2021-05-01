package com.augusto.bigball.data.api.exception

import com.augusto.bigball.core.domain.entity.Result
import java.io.IOException

class NoConnectionException: IOException(), ApiError {

    override fun toError(): Result.Error {
        return Result.Error(message = "Sem conexão")
    }
}