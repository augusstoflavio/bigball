package com.augusto.bigball.data.api.exception
import com.augusto.bigball.core.domain.entity.Result

interface ApiError {

    fun toError(): Result.Error
}