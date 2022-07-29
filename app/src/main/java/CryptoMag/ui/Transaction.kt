package CryptoMag.ui

import CryptoMag.model.OfferModel
import CryptoMag.model.User
import CryptoMag.ui.BDUser.Companion.offerListData
import CryptoMag.listener.WalletChange


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
            offer.sellerWallet += offer.sellPrice
            offer.sellerCryptoWallet -= offer.sellQuantity
            offerListData.remove(offer)
            println("Operation success")
            market.marketPlace(profile)
        } else {
            println("Error")
            market.marketPlace(profile)
        }
    }
}




