package CryptoMag.ui

import CryptoMag.model.ConfidentialDataModel
import CryptoMag.model.OfferModel
import CryptoMag.model.User

class Login {

    private lateinit var currentUser: User

    fun loginCheck(confidentialData: ConfidentialDataModel) {

        val bd = BDUser()
        var flag = false

        bd.userList.forEachIndexed { _, user ->
            if (confidentialData.login == user.loginData.login &&
                confidentialData.password == user.loginData.password
            ) {
                currentUser = user
                flag = true
            }
        }

        if (flag) {
            println("\nLogIn \nWelcome ${currentUser.userInfo.userName}")
            MainMenu().menu(currentUser)
        } else {
            println("Incorrect")
        }
    }
}