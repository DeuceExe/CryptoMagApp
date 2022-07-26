package CryptoMag.ui

import CryptoMag.Enums.Roles
import CryptoMag.Models.User

class MainMenu {

    private val market = Market()

    fun menu(profile: User) {

        when (profile.userRole) {

            Roles.User -> {

                print("\n1.Market \n2.Check balance \n3.Change Password \n4.LogOut \nChoose action: ")

                when (readln().toInt()) {
                    1 -> market.marketPlace(profile)
                    2 -> {
                        println(
                            "Your balance: ${profile.userInfo.wallet.wallet}$ and " +
                                    "${profile.userInfo.wallet.cryptoWallet} BTC"
                        )
                        menu(profile)
                    }
                    3 -> {
                        print("Enter new password: ")
                        profile.loginData.password = readln()
                        menu(profile)
                    }
                    4 -> logIn()
                }
            }
            Roles.Administrator -> {

                print("\n1.Market \n2.Check balance \n3.Check transactions \n4.Change password \n5.LogOut \nChoose action: ")

                when (readln().toInt()) {
                    1 -> market.marketPlace(profile)
                    2 -> {
                        println(
                            "Your balance: ${profile.userInfo.wallet.wallet}$ and " +
                                    "${profile.userInfo.wallet.cryptoWallet} crypto"
                        )
                        menu(profile)
                    }
                    3 -> println("Developing")
                    4 -> {
                        print("Enter new password: ")
                        profile.loginData.password = readln()
                        menu(profile)
                    }
                    5 -> logIn()
                }
            }
        }
    }
}