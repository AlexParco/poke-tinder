package com.alexander.parco.lab08.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alexander.parco.lab08.databinding.ActivityLoginBinding
import com.alexander.parco.lab08.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = LoginViewModel(this)

        loginViewModel.onCreate()
        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        loginViewModel.emptyFieldError.observe(this){
            Toast.makeText(this, "Ingrese los datos de usuario", Toast.LENGTH_SHORT).show()
        }
        loginViewModel.fieldsAuthenticationError.observe(this){
            Toast.makeText(this, "Error usuario", Toast.LENGTH_SHORT).show()
        }
        loginViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun startLogin() {
        Log.i("USER",binding.edtEmail.text.toString() )
        Log.i("USER",binding.edtPassword.text.toString() )
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }

}