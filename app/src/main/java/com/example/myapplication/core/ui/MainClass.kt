package com.example.myapplication.core.ui

import com.example.myapplication.core.model.ConfidentialDataModel

fun main() {

    logIn()
}

fun logIn() {
    val bD = BDUser()

    print("Enter your Login: ")
    val logName = readln()

    print("Enter your Password: ")
    val logPassword = readln()

    bD.configUser(ConfidentialDataModel(logName, logPassword))
}