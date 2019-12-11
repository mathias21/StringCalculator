package com.rego.jorge.stringcalculator

class MainPresenter {

    fun onLoginButtonClick(username: String, password: String): Boolean {
        return isCorrectLogin(username, password)
    }

    private fun isCorrectLogin(username: String, password: String): Boolean {
        return username == "admin" && password == "admin"
    }

    fun onLogoutButtonClick(currentTimeInMillis: Long): Boolean {
        return (currentTimeInMillis/1000 % 2).toInt() == 0
    }


}