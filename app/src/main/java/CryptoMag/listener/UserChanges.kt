package CryptoMag.listener

import CryptoMag.model.User

interface UserChanges {
    fun saveUserData(userSaved: Array<User>)
}