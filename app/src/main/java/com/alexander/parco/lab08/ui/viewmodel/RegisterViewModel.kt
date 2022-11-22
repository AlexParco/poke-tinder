package com.alexander.parco.lab08.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexander.parco.lab08.data.models.User
import com.alexander.parco.lab08.util.SharedPreferenceUtil

class RegisterViewModel(
    private val context: Context
): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyFieldError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    init {
        onCreate()
    }

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(user: User){
        if (user.name.isEmpty() || user.email.isEmpty() || user.password.isEmpty()){
            emptyFieldError.postValue(true)
        }else{
            goSuccessActivity.postValue(true)
        }
        sharedPreferenceUtil.saveUser(user)
    }
}