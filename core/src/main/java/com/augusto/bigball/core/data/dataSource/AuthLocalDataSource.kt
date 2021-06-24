package com.augusto.bigball.core.data.dataSource

interface AuthLocalDataSource {
     fun isLoggedIn(): Boolean
     fun saveUser(name: String, token: String)
     fun logoff()
     fun getToken(): String?
}