package com.alexander.parco.lab08.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexander.parco.lab08.data.models.User
import com.alexander.parco.lab08.util.SharedPreferenceUtil

class LoginViewModel (
    private val context: Context
): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldError = MutableLiveData<Boolean>()
    val fieldsAuthenticationError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(email: String, password:String){
        if (email.isEmpty() && password.isEmpty()){
            emptyFieldError.postValue(true)
        }

        val user: User? = sharedPreferenceUtil.getUser()

        if (email == user?.email && password == user?.password ){
            goSuccessActivity.postValue(true)
        }else{
            fieldsAuthenticationError.postValue(true)
        }
    }



}