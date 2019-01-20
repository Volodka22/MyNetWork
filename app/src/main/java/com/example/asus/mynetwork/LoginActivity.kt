package com.example.asus.mynetwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signIn.setOnClickListener {
            if (password.text.toString() == "" && login.text.toString() == "")
                Snackbar.make(
                    consLay,
                    getString(com.example.asus.mynetwork.R.string.login_and_password_is_empty),
                    Snackbar.LENGTH_SHORT
                ).show()
            else if (password.text.toString() == "")
                Snackbar.make(
                    consLay,
                    getString(com.example.asus.mynetwork.R.string.password_is_empty),
                    Snackbar.LENGTH_SHORT
                ).show()
            else if (login.text.toString() == "")
                Snackbar.make(
                    consLay,
                    getString(com.example.asus.mynetwork.R.string.login_is_empty),
                    Snackbar.LENGTH_SHORT
                ).show()
            else if (password.text.toString() != "test" || login.text.toString() != "test")
                Snackbar.make(
                    consLay,
                    getString(com.example.asus.mynetwork.R.string.password_or_login_is_incorrect),
                    Snackbar.LENGTH_SHORT
                ).show()
            else
                startActivity(Intent(this, Feed::class.java))


        }
    }
}
