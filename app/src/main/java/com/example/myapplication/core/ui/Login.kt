package com.example.myapplication.core.ui

import com.example.myapplication.core.model.ConfidentialDataModel
import com.example.myapplication.core.model.User

class Login : BDUser() {

    private lateinit var currentUser: User
    var flag = false

    fun initLogin(confidentialData: ConfidentialDataModel) {
        checkLogin(confidentialData)
        getStartScreen()
    }

    private fun checkLogin(confidentialData: ConfidentialDataModel) {
        if (userListData.isEmpty()) {
            validateLogin(confidentialData)
        } else {
            userListData.forEachIndexed { _, user ->
                if (confidentialData.login == user.loginData.login &&
                    confidentialData.password == user.loginData.password
                ) {
                    currentUser = user
                    flag = true
                }
                if (!flag) {
                    validateLogin(confidentialData)
                }
            }
        }
    }

    private fun validateLogin(confidentialData: ConfidentialDataModel) {
        val bd = BDUser()
        bd.userList.forEachIndexed { _, user ->
            if (confidentialData.login == user.loginData.login &&
                confidentialData.password == user.loginData.password
            ) {
                currentUser = user
                flag = true
            }
        }
    }

    private fun getStartScreen() {
        if (flag) {
            println("\nLogIn \nWelcome ${currentUser.userInfo.userName}")
            MainMenu().menu(currentUser)
        } else {
            println("Incorrect")
        }
    }
}