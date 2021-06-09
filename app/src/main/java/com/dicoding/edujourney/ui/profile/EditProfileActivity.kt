package com.dicoding.edujourney.ui.profile

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.User
import com.dicoding.edujourney.core.ui.ProfilePreference
import com.dicoding.edujourney.databinding.ActivityEditProfileBinding
import java.text.SimpleDateFormat
import java.util.*

class EditProfileActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerFragment.DialogDateListener {
    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
        private const val FIELD_REQUIRED = "Field cannot be blank"
        private const val FIELD_DIGIT_ONLY = "Only Accept Number"
    }

    private lateinit var profilePreference: ProfilePreference
    private lateinit var user: User
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilePreference = ProfilePreference(this)
        user = profilePreference.getUser()

        binding.btnSave.setOnClickListener(this)
        binding.edtTgl.setOnClickListener(this)
        editPreference()
    }

    private fun editPreference() {
        with(binding) {
            tvEditUsername.text = user.username
            tvEmailProfile.text = user.email
            edtFirstName.setText(user.firstName)
            edtLastName.setText(user.lastName)
            edtTelp.setText(user.phoneNumber)
            edtTgl.setText(user.date)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_save ->
                with(binding) {
                    val firstName = edtFirstName.text.toString().trim()
                    val lastName = edtLastName.text.toString().trim()
                    val phone = edtTelp.text.toString().trim()
                    val birth = edtTgl.text.toString().trim()
                    if (firstName.isEmpty()) {
                        edtFirstName.error = FIELD_REQUIRED
                        return
                    }
                    if (lastName.isEmpty()) {
                        edtLastName.error = FIELD_REQUIRED
                    }
                    if (phone.isEmpty()) {
                        edtTelp.error = FIELD_REQUIRED
                        return
                    }
                    if (!phone.isDigitsOnly()) {
                        edtTelp.error = FIELD_DIGIT_ONLY
                    }
                    if (birth.isEmpty()) {
                        edtTgl.error = FIELD_REQUIRED
                    }

                    saveUser(firstName, lastName, phone, birth)
                }
            R.id.edt_tgl -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)
            }
        }
    }

    private fun saveUser(firstName: String, lastName: String, phone: String, birth: String) {
        val profilePreference = ProfilePreference(this)
        val user = profilePreference.getUser()
        val set = User(
            user.username,
            user.email,
            firstName,
            lastName,
            phone,
            birth,
            user.password,
            user.login
        )
        profilePreference.setUser(set)
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        binding.edtTgl.setText(dateFormat.format(calendar.time))
    }


}