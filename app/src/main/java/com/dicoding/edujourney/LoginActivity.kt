package com.dicoding.edujourney

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.edujourney.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
    }

    private fun login() {
        with(binding) {
            btnLogin.setOnClickListener(this@LoginActivity)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> TODO("user availability")
            R.id.btn_register -> {
                val intent = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}