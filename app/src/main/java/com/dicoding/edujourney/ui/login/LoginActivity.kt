package com.dicoding.edujourney.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.edujourney.HomeActivity
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.User
import com.dicoding.edujourney.databinding.ActivityLoginBinding
import com.dicoding.edujourney.core.ui.ProfilePreference

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val FIELD_REQUIRED = "Field cannot be blank"
        private const val INCORRECT_REQ = "Incorrect Email or Password "
    }

    private lateinit var profilePreference: ProfilePreference
    private lateinit var user: User
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        profilePreference = ProfilePreference(this)
        user = profilePreference.getUser()
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> {
                with(binding) {
                    val email = edtEmail.text.toString().trim()
                    val password = edtPw.text.toString().trim()
                    if (email.isEmpty()) {
                        edtEmail.error = FIELD_REQUIRED
                    }
                    if (password.isEmpty()) {
                        edtPw.error = FIELD_REQUIRED
                    }
                    if (user.username.isNullOrEmpty()){
                        profilePreference.setUser(User())
                        user = profilePreference.getUser()
                    }
                    if (email == user.email && password == user.password) {
                        setLogin()
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        finish()
                    } else if(email.isNotEmpty() || password.isNotEmpty()) {
                        edtEmail.error = INCORRECT_REQ
                        edtPw.error = INCORRECT_REQ
                    }
                }
            }
            R.id.btn_register ->{
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }

    private fun setLogin() {
        val login = User(
            user.username,
            user.email,
            user.firstName,
            user.lastName,
            user.phoneNumber,
            user.date,
            user.password,
            true
        )
        profilePreference.setUser(login)
    }
}