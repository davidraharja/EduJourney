package com.dicoding.edujourney.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dicoding.edujourney.R
import com.dicoding.edujourney.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegisterNow.setOnClickListener(this)
        binding.btnBackLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_registerNow ->{
                Toast.makeText(this,"Register Currently Unavailable, Login with \nemail: admin@gmail.com \nPassword: admin", Toast.LENGTH_LONG).show()
            }
            R.id.btn_backLogin ->{
                finish()
            }
        }

    }
}