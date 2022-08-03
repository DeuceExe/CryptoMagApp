package com.example.myapplication.core.ui

import com.example.myapplication.core.model.*
import com.example.myapplication.core.ui.BDUser.Companion.offerListData

class Market {

    fun marketPlace(profile: User) {

        getMarketMenu(profile)

        when (readln().toInt()) {
            1 -> {
                println("Current currency: \n-$DOLLAR BYN \n-$BTC$")
                marketPlace(profile)
            }
            2 -> buyCryptoCoin(profile)
            3 -> sellCryptoCoin(profile)
            4 -> checkAvailableTransactions(profile)
            5 -> MainMenu().menu(profile)
            else -> errorMessage(profile)
        }
    }

    private fun checkAvailableTransactions(profile: User) {
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

    private fun sellCryptoCoin(profile: User) {
        val db = BDUser()

        println("You sell: ")
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
                errorMessage(profile)
            }
        } else {
            errorMessage(profile)
        }
    }

    private fun buyCryptoCoin(profile: User) {
        if (offerListData.isEmpty()) {
            emptyOffer(profile)
        } else {
            offerListData.forEachIndexed { index, it ->
                if (profile.userInfo.userName != it.sellerName) {
                    println("${index.plus(NUMERIC_ONE)} \t${it.sellerName} \tSell: ${it.sellQuantity} BTC \t${it.sellPrice}$\n")
                } else {
                    emptyOffer(profile)
                }
            }
        }
        print("Choose position for buying ('cancel' for return): ")

        when (val input = readln()) {
            "cancel" -> marketPlace(profile)
            else -> {
                Transaction().makeTransaction(
                    offerListData[input.toInt().minus(NUMERIC_ONE)],
                    profile
                )
            }
        }
    }

    private fun getMarketMenu(profile: User) {
        print(
            "\nYour balance: \n${profile.userInfo.wallet.wallet}$" +
                    "\n${profile.userInfo.wallet.cryptoWallet} BTC\n" +
                    "\nCrypto Market... \n1.Check currency exchange \n2.Buy \n3.Sell \n4.My transactions " +
                    "\n5.Back to menu \nChoose action: "
        )
    }

    private fun errorMessage(profile: User) {
        println("Incorrect")
        marketPlace(profile)
    }

    private fun emptyOffer(profile: User) {
        println("Empty")
        marketPlace(profile)
    }

    companion object {

        const val NUMERIC_ONE = 1
        const val DOLLAR = 2.52
        const val BTC = 22650.90
    }
}