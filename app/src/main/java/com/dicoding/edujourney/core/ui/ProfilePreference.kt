package com.dicoding.edujourney.core.ui

import android.content.Context
import androidx.core.content.edit
import com.dicoding.edujourney.core.domain.model.User

internal class ProfilePreference(context: Context) {
    companion object{
        private const val PREFS_NAME = "user_pref"
        private const val EMAIL = "email"
        private const val USER_NAME = "user_name"
        private const val FIRST_NAME = "first_name"
        private const val LAST_NAME = "last_name"
        private const val PHONE_NUMBER = "phone"
        private const val BIRTH_DATE = "birth"
        private const val PASSWORD = "password"
        private const val LOGGEDIN = "loggedin"
    }
    private val preferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)

    fun setUser(value: User){
        preferences.edit {
            putString(EMAIL,value.email)
            putString(USER_NAME, value.username)
            putString(FIRST_NAME,value.firstName)
            putString(LAST_NAME,value.lastName)
            putString(PHONE_NUMBER,value.phoneNumber)
            putString(BIRTH_DATE,value.date)
            putString(PASSWORD,value.password)
            putBoolean(LOGGEDIN,value.login)
        }
    }
    fun getUser() : User{
        val model = User()
        with(model){
            email = preferences.getString(EMAIL, "")
            username = preferences.getString(USER_NAME,"")
            firstName = preferences.getString(FIRST_NAME,"")
            lastName = preferences.getString(LAST_NAME,"")
            phoneNumber = preferences.getString(PHONE_NUMBER, "")
            date = preferences.getString(BIRTH_DATE, "")
            password = preferences.getString(PASSWORD,"")
            login = preferences.getBoolean(LOGGEDIN,false)

        }
        return model
    }
}