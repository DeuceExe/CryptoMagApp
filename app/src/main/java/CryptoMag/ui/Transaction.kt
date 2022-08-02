package CryptoMag.ui

import CryptoMag.ui.BDUser.Companion.offerListData
import CryptoMag.model.*
import CryptoMag.ui.BDUser.Companion.userListData


open class Transaction {

    fun makeTransaction(offer: OfferModel, profile: User) {
        val market = Market()
        println(
            "Operation between You and ${offer.sellerName}\n" +
                    "You buy ${offer.sellQuantity} BTC for ${offer.sellPrice}"
        )
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
               if(it.userInfo.userName == offer.sellerName){
                   it.userInfo.wallet.wallet += offer.sellPrice
               }
            }
            println("Operation success")
            market.marketPlace(profile)
        } else {
            println("Error")
            market.marketPlace(profile)
        }
    }
}




