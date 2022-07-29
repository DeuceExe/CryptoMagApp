package CryptoMag.listener

import CryptoMag.model.User

interface WalletChange {
    fun saveUserWallet(userWallet: User)
}