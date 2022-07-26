package CryptoMag.Models

import CryptoMag.Enums.Roles

data class User(
    val userRole: Roles,
    val loginData: ConfidentialDataModel,
    val userInfo: UnconfidentialDataModel
)