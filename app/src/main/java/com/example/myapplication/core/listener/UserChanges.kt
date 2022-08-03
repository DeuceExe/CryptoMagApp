package com.example.myapplication.core.listener

import com.example.myapplication.core.model.User

interface UserChanges {

    fun saveUserData(userSaved: Array<User>)
}