package com.rego.jorge.stringcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            if(isCorrectLogin()) {
                showLogged()
            } else {
                showError()
            }
        }

        logoutButton.setOnClickListener {
            showLogin()
        }

        showLogin()
    }

    private fun showError() {
        Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show()
    }

    private fun isCorrectLogin(): Boolean {
        return usernameEditText?.text.toString() == "admin" && passwordEditText?.text.toString() == "admin"
    }

    private fun showLogged() {
        loginButton?.visibility = View.GONE
        usernameEditText?.visibility = View.GONE
        passwordEditText?.visibility = View.GONE

        logoutButton?.visibility = View.VISIBLE
    }

    private fun showLogin() {
        loginButton?.visibility = View.VISIBLE
        usernameEditText?.run {
            setText("")
            visibility = View.VISIBLE
        }

        passwordEditText?.run {
            setText("")
            visibility = View.VISIBLE
        }

        logoutButton?.run {
            visibility = View.GONE
            setOnClickListener {
                showLogin()
            }
        }
    }
}
