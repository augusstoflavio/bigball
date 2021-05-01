package com.augusto.bigball.data.local


class SharedDataSourceImpl(private val preferences: Preferences): SharedPreferencesDataSource {

    override fun isLogged(): Boolean {
        return preferences.getToken() != null
    }

    override fun saveUser(name: String, token: String) {
        preferences.putName(name)
        preferences.putToken(token)
    }

    override fun clear() {
        preferences.clear()
    }

    override fun getToken(): String? {
        return preferences.getToken()
    }
}