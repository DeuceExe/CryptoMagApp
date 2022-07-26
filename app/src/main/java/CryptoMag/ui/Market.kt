package CryptoMag.ui

import CryptoMag.Models.OfferModel
import CryptoMag.Models.User
import android.widget.ArrayAdapter

interface Offer {
    fun saveOffer(offer: Array<OfferModel>): Array<OfferModel>
}

class Market {

    private var offerList: Array<OfferModel> = arrayOf()

    fun marketPlace(profile: User) {
        print(
            "\nYour balance: \n${profile.userInfo.wallet.wallet}$" +
                    "\n${profile.userInfo.wallet.cryptoWallet} BTC\n" +
                    "\nCrypto Market... \n1.Check currency exchange \n2.Buy \n3.Sell \n4.Back to menu " +
                    "\nChoose action: "
        )

        when (readln().toInt()) {
            1 -> {
                println("Current currency: \n-$DOLLAR BYN \n-$BTC$")
                marketPlace(profile)
            }
            2 -> {
                val login = Login()
                login.saveOffer(offerList)
                offerList.forEachIndexed { index, it ->
                    if (profile.userInfo.userName != it.sellerName) {
                        println("${index}Seller: ${it.sellerName} Sell: ${it.sellQuantity}BTC Price: ${it.sellPrice}$")
                    } else {
                        println("empty")
                        marketPlace(profile)
                    }
                    print("Choose position for buying: ")
                }
            }
            3 -> {
                print("You sell: ")
                val quantity = readln().toDouble()
                if (quantity <= profile.userInfo.wallet.cryptoWallet) {
                    print("For price: ")
                    val price = readln().toDouble()
                    if (price > 0) {
                        offerList +=
                            OfferModel(profile.userInfo.userName, quantity, price)
                        setDataOffer(offerList)
                        marketPlace(profile)
                    } else {
                        println("Incorrect data")
                        marketPlace(profile)
                    }
                } else {
                    println("Incorrect data")
                    marketPlace(profile)
                }
            }
            4 -> MainMenu().menu(profile)
        }
    }

    private fun setDataOffer(offer: Array<OfferModel>){
        val log = Login()
        log.saveOffer(offerList)
    }

    companion object {
        const val DOLLAR = 2.52
        const val BTC = 22650.90
    }
}