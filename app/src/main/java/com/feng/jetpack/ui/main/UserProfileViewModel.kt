package com.feng.jetpack.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feng.jetpack.entity.User

open class UserProfileViewModel : ViewModel() {
    
    val user: MutableLiveData<User> = MutableLiveData<User>().apply {
        this.value = User("wang", 3)
    }

    fun update() {
        user.value?.let {
            it.age = it.age.plus(1)
            user.value = it
        }
    }
}