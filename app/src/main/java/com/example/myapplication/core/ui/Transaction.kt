package com.example.myapplication.core.ui

import com.example.myapplication.core.model.*
import com.example.myapplication.core.ui.BDUser.Companion.offerListData
import com.example.myapplication.core.ui.BDUser.Companion.userListData

class Transaction {

    fun makeTransaction(offer: OfferModel, profile: User) {
        val market = Market()

        transactionScreen(offer)

        if (profile.userInfo.wallet.wallet > offer.sellPrice) {
            profile.userInfo.wallet.cryptoWallet += offer.sellQuantity
            profile.userInfo.wallet.wallet -= offer.sellPrice
            offerListData.remove(offer)
            BDUser().saveUserData(
                arrayOf(
                    User(
                        profile.userRole,
                        ConfidentialDataModel(profile.loginData.login, profile.loginData.password),
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
            userListData.forEachIndexed { _, it ->
                if (it.userInfo.userName == offer.sellerName) {
                    it.userInfo.wallet.wallet += offer.sellPrice
                }
            }
            goToMarket("Operation success", market, profile)
        } else {
            goToMarket("Error", market, profile)
        }
    }

    private fun transactionScreen(offer: OfferModel) {
        println(
            "Operation between You and ${offer.sellerName}\n" +
                    "You buy ${offer.sellQuantity} BTC for ${offer.sellPrice}$"
        )
    }

    private fun goToMarket(message: String, market: Market, profile: User) {
        println(message)
        market.marketPlace(profile)
    }
}




