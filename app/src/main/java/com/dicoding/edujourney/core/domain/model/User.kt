package com.dicoding.edujourney.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String? = "admin",
    var email: String? = "admin@gmail.com",
    var firstName: String? = "Admin",
    var lastName: String? = "Istrator",
    var phoneNumber: String? = "082111739509",
    var date: String? = "09/12/1995",
    var password: String? = "admin",
    var login: Boolean = false
) : Parcelable
