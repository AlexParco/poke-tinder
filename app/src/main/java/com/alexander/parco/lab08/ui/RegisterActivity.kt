package com.alexander.parco.lab08.ui

import android.content.Intent
import android.os.Bundle
import com.alexander.parco.lab08.util.SharedPreferenceUtil
import com.alexander.parco.lab08.databinding.ActivityRegisterBinding
import com.alexander.parco.lab08.data.models.User

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferences: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        binding.btnRegister.setOnClickListener {
            val userId = "1"
            val username = binding.edtUserName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            val user = User(
                userId,
                username,
                email,
                password
            )
            sharedPreferences.saveUser(user)
            startActivity(Intent(this, LoginActivity::class.java))

        }
        binding.btnGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}