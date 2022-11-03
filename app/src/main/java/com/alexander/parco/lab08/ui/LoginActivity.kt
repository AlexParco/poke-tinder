package com.alexander.parco.lab08.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alexander.parco.lab08.util.SharedPreferenceUtil
import com.alexander.parco.lab08.databinding.ActivityLoginBinding
import com.alexander.parco.lab08.data.models.User

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
    fun startLogin(){
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        val user: User? = sharedPreferenceUtil.getUser()

        if(email == user?.email && password == user.password){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this,"Error usuario", Toast.LENGTH_SHORT).show()
        }
    }

}