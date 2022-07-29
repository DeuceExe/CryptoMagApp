package CryptoMag.model

import CryptoMag.enum.Roles

data class User(
    val userRole: Roles,
    val loginData: ConfidentialDataModel,
    val userInfo: UnconfidentialDataModel
)