package com.augusto.bigball.data.local

interface SharedPreferencesDataSource {

    fun isLogged(): Boolean
    fun saveUser(name: String, token: String)
    fun clear()
    fun getToken(): String?
}