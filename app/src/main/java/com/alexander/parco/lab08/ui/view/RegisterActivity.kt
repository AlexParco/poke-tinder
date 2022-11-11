package com.alexander.parco.lab08.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alexander.parco.lab08.databinding.ActivityRegisterBinding
import com.alexander.parco.lab08.data.models.User
import com.alexander.parco.lab08.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModel = RegisterViewModel(this)

        binding.btnGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
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
            registerViewModel.validateInputs(user)
        }

        registerViewModel.emptyFieldError.observe(this){
            Toast.makeText(this, "Ingrese los datos para el registro", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}