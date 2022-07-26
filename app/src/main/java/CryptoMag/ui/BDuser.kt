package CryptoMag.ui

import CryptoMag.Enums.Roles
import CryptoMag.Models.ConfidentialDataModel
import CryptoMag.Models.UnconfidentialDataModel
import CryptoMag.Models.User
import CryptoMag.Models.Wallet

open class BDUser {

    var userList: Array<User> = arrayOf(
        User(
            Roles.User,
            ConfidentialDataModel("tata220", "123"),
            UnconfidentialDataModel("Stepan", Wallet(115.0, 0.014))
        ),
        User(
            Roles.User,
            ConfidentialDataModel("deadman", "dinside11"),
            UnconfidentialDataModel("David", Wallet(647.0, 0.0004))
        ),
        User(
            Roles.Administrator,
            ConfidentialDataModel("admin", "admin"),
            UnconfidentialDataModel("Anaconda", Wallet(7500.0, 2.0))
        )
    )

    fun configUser(user: ConfidentialDataModel) {
        Login().loginCheck(user)
    }
}