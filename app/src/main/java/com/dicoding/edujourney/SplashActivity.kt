package com.dicoding.edujourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.edujourney.core.domain.model.User
import com.dicoding.edujourney.databinding.ActivitySplashBinding
import com.dicoding.edujourney.ui.login.LoginActivity
import com.dicoding.edujourney.core.ui.ProfilePreference

class SplashActivity : AppCompatActivity() {
    companion object{
        private const val timeDelay = 1000L
    }
    private lateinit var binding: ActivitySplashBinding
    private lateinit var profilePreference: ProfilePreference
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        profilePreference = ProfilePreference(this)
        user = profilePreference.getUser()
        Handler(Looper.getMainLooper()).postDelayed({
            if (user.login) {
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, timeDelay)
    }
}