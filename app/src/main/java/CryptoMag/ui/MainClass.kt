package CryptoMag.ui

import CryptoMag.Models.ConfidentialDataModel

fun main() {

    logIn()
}

fun logIn() {
    val bD = BDUser()

    print("Enter your username: ")
    val logName = readln()

    print("Enter your password: ")
    val logPassword = readln()

    bD.configUser(ConfidentialDataModel(logName, logPassword))
}