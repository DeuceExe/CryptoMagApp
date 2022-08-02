package CryptoMag.ui

import CryptoMag.model.*
import CryptoMag.ui.BDUser.Companion.offerListData


class Market {

    fun marketPlace(profile: User) {

        val db = BDUser()
        fun errorMessage() {
            println("Incorrect")
            marketPlace(profile)
        }

        fun emptyOffer() {
            println("Empty")
            marketPlace(profile)
        }

        print(
            "\nYour balance: \n${profile.userInfo.wallet.wallet}$" +
                    "\n${profile.userInfo.wallet.cryptoWallet} BTC\n" +
                    "\nCrypto Market... \n1.Check currency exchange \n2.Buy \n3.Sell \n4.My transactions " +
                    "\n5.Back to menu \nChoose action: "
        )

        when (readln().toInt()) {
            1 -> {
                println("Current currency: \n-$DOLLAR BYN \n-$BTC$")
                marketPlace(profile)
            }
            2 -> {
                if (offerListData.isEmpty()) {
                    emptyOffer()
                } else {
                    offerListData.forEachIndexed { index, it ->
                        if (profile.userInfo.userName != it.sellerName) {
                            println("${index.plus(1)} \t${it.sellerName} \tSell: ${it.sellQuantity} BTC \t${it.sellPrice}$\n")
                        } else {
                            emptyOffer()
                        }
                    }
                }
                print("Choose position for buying ('cancel' for return): ")

                when (val input = readln()) {
                    "cancel" -> marketPlace(profile)
                    else -> {
                        Transaction().makeTransaction(
                            offerListData[input.toInt().minus(1)],
                            profile
                        )
                    }
                }
            }
            3 -> {
                println()
                print("You sell: ")
                val quantity = readln().toDouble()
                if (quantity <= profile.userInfo.wallet.cryptoWallet) {
                    print("For price: ")
                    val price = readln().toDouble()
                    if (price > 0) {
                        db.saveOffer(
                            arrayOf(
                                OfferModel(
                                    profile.userInfo.userName,
                                    quantity,
                                    price,
                                    profile.userInfo.wallet.wallet,
                                    profile.userInfo.wallet.cryptoWallet
                                )
                            )
                        )
                        profile.userInfo.wallet.cryptoWallet -= quantity
                        db.saveUserData(
                            arrayOf(
                                User(
                                    profile.userRole,
                                    ConfidentialDataModel(
                                        profile.loginData.login,
                                        profile.loginData.password
                                    ),
                                    UnconfidentialDataModel(
                                        profile.userInfo.userName,
                                        Wallet(
                                            profile.userInfo.wallet.wallet,
                                            profile.userInfo.wallet.cryptoWallet
                                        )
                                    )
                                )
                            )
                        )
                        marketPlace(profile)
                    } else {
                        errorMessage()
                    }
                } else {
                    errorMessage()
                }
            }
            4 -> {
                if (offerListData.isEmpty()) {
                    println("Your have no transactions")
                    marketPlace(profile)
                }
                offerListData.forEach {
                    if (profile.userInfo.userName == it.sellerName) {
                        println("Seller: ${it.sellerName} \tSell:${it.sellQuantity} BTC \tPrice:${it.sellPrice}$")
                    }
                }
                marketPlace(profile)
            }
            5 -> {
                MainMenu().menu(profile)
            }
            else -> {
                errorMessage()
            }
        }
    }

    companion object {
        const val DOLLAR = 2.52
        const val BTC = 22650.90
    }
}