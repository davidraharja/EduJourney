package com.dicoding.edujourney.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.edujourney.R
import com.dicoding.edujourney.core.domain.model.User
import com.dicoding.edujourney.core.ui.ProfilePreference
import com.dicoding.edujourney.databinding.FragmentProfileBinding
import com.dicoding.edujourney.ui.history.HistoryActivity
import com.dicoding.edujourney.ui.login.LoginActivity

class ProfileFragment : Fragment(), View.OnClickListener {

    private var _fragmentProfileBinding: FragmentProfileBinding? = null
    private val binding get() = _fragmentProfileBinding
    private lateinit var profilePreference: ProfilePreference
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profilePreference = ProfilePreference(requireActivity())
        user = profilePreference.getUser()
        setupBinding()

    }

    private fun setupBinding() {
        binding?.tvUsername?.text = user.username
        binding?.tabChangeProfile?.setOnClickListener(this)
        binding?.tabLogout?.setOnClickListener(this)
        binding?.tabPurchaseHisotry?.setOnClickListener(this)
        binding?.tabAboutUs?.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentProfileBinding = null
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tab_change_profile -> {
                startActivity(Intent(activity, EditProfileActivity::class.java))
            }
            R.id.tab_logout -> {
                setLogin()
                startActivity(Intent(activity, LoginActivity::class.java))
                activity?.finish()
            }
            R.id.tab_purchase_hisotry -> {
                startActivity(Intent(activity, HistoryActivity::class.java))
            }
            R.id.tab_about_us ->{

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
            false
        )
        profilePreference.setUser(login)
    }
}