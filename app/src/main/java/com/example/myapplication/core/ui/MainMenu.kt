package com.example.myapplication.core.ui

import com.example.myapplication.core.enum.Roles
import com.example.myapplication.core.model.User

class MainMenu {

    fun menu(profile: User) {

        checkBalance(profile)

        when (profile.userRole) {
            Roles.User -> {
                getRoleActions(profile)
            }
            Roles.Administrator -> {
                getRoleActions(profile)
            }
        }
    }

    private fun checkBalance(profile: User) {
        println(
            "Your balance: ${profile.userInfo.wallet.wallet}$ and " +
                    "${profile.userInfo.wallet.cryptoWallet} BTC"
        )
        menu(profile)
    }

    private fun getRoleActions(profile: User) {
        if (profile.userRole == Roles.User) {
            print("\n1.Market \n2.Check balance \n3.Change Password \n4.LogOut \nChoose action: ")
        } else {
            print("\n1.Market \n2.Check balance \n3.Change password \n4.LogOut \n5.Check transactions \nChoose action: ")
        }

        when (readln().toInt()) {
            1 -> Market().marketPlace(profile)
            2 -> checkBalance(profile)
            3 -> {
                print("Enter new password: ")
                profile.loginData.password = readln()
                menu(profile)
            }
            4 -> {
                println()
                logIn()
            }
            5 -> {
                println("Developing")
                menu(profile)
            }
            else -> {
                println("Incorrect")
                menu(profile)
            }
        }
    }
}