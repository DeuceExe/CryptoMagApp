package CryptoMag.ui

import CryptoMag.Models.ConfidentialDataModel
import CryptoMag.Models.OfferModel
import CryptoMag.Models.User

class Login: Offer {

    private lateinit var currentUser: User
    private val mainMenu = MainMenu()

    override fun saveOffer(offer: Array<OfferModel>): Array<OfferModel>{
        return offer
    }

    fun loginCheck(confidentialData: ConfidentialDataModel) {

        val bd = BDUser()
        var flag = false

        bd.userList.forEachIndexed { _, user ->
            if (confidentialData.login == user.loginData.login &&
                confidentialData.password == user.loginData.password) {
                currentUser = user
                flag = true
            }
        }

        if (flag) {
            val market = Market()
            println("\nLogIn \nWelcome ${currentUser.userInfo.userName}")
            mainMenu.menu(currentUser)
        } else {
            println("Incorrect")
        }
    }
}