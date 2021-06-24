package com.augusto.bigball.ui

import androidx.lifecycle.ViewModel
import com.augusto.bigball.core.domain.useCase.IsLoggedIn

class MainViewModel(private val isLogged: IsLoggedIn): ViewModel() {

    fun isLoggedIn(): Boolean {
        return isLogged.invoke()
    }
}