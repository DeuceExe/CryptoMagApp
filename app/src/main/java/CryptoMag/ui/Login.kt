package CryptoMag.ui

import CryptoMag.model.ConfidentialDataModel
import CryptoMag.ui.BDUser.Companion.userListData
import CryptoMag.model.User

class Login: BDUser() {

    private lateinit var currentUser: User

    fun loginCheck(confidentialData: ConfidentialDataModel) {

        val bd = BDUser()
        var flag = false

        fun logining(){
            bd.userList.forEachIndexed { _, user ->
                if (confidentialData.login == user.loginData.login &&
                    confidentialData.password == user.loginData.password
                ) {
                    currentUser = user
                    flag = true
                }
            }
        }
        if (userListData.isEmpty()) {
            logining()
        } else {
            userListData.forEachIndexed { _, user ->
                if (confidentialData.login == user.loginData.login &&
                    confidentialData.password == user.loginData.password
                ) {
                    currentUser = user
                    flag = true
                }
                if(!flag){
                    logining()
                }
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