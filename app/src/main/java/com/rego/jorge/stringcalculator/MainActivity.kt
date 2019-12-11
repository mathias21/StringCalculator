package com.rego.jorge.stringcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            if(presenter.onLoginButtonClick(usernameEditText.text.toString(), passwordEditText.text.toString())) {
                showLogged()
            } else {
                showError()
            }
        }

        logoutButton.setOnClickListener {
            if(presenter.onLogoutButtonClick(System.currentTimeMillis())) {
                showLogin()
            } else {
                showLogoutError()
            }
        }

        showLogin()
    }

    private fun showLogoutError() {
        Toast.makeText(this, "Wrong logout time", Toast.LENGTH_LONG).show()
    }

    private fun showError() {
        Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show()
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

        logoutButton?.visibility = View.GONE
    }
}
