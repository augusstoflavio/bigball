package com.augusto.bigball.data.validator

interface EmailValidator {

    fun isValid(email: String): Boolean
}