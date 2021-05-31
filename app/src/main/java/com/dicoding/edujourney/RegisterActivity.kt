package com.dicoding.edujourney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.edujourney.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        register()
    }

    private fun register() {
        with(binding){
            btnRegisterNow.setOnClickListener(this@RegisterActivity)
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_registerNow -> TODO("kirim konfirmasi")
            R.id.btn_backLogin -> finish()
        }
    }
}