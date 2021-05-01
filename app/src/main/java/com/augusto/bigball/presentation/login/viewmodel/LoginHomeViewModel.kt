package com.augusto.bigball.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augusto.bigball.data.local.SharedPreferencesDataSource

class LoginHomeViewModel(private val sharedPreferencesDataSource: SharedPreferencesDataSource): ViewModel() {

    private val _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean> = _isLogged

    fun checkIsLogged() {
        _isLogged.value = sharedPreferencesDataSource.isLogged()
    }
}