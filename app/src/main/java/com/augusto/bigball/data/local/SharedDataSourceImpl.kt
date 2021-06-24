package com.augusto.bigball.data.local

import com.augusto.bigball.core.data.dataSource.AuthLocalDataSource

class SharedDataSourceImpl(private val preferences: Preferences): AuthLocalDataSource {

    override fun saveUser(name: String, token: String) {
        preferences.putName(name)
        preferences.putToken(token)
    }

    override fun isLoggedIn(): Boolean {
        return preferences.getToken() != null
    }

    override fun logoff() {
        preferences.clear()
    }

    override fun getToken(): String? {
        return preferences.getToken()
    }
}