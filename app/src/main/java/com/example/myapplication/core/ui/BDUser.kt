package com.example.myapplication.core.ui

import com.example.myapplication.core.enum.Roles
import com.example.myapplication.core.listener.Offer
import com.example.myapplication.core.listener.UserChanges
import com.example.myapplication.core.model.*

open class BDUser : Offer, UserChanges {

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
        Login().initLogin(user)
    }

    override fun saveOffer(offer: Array<OfferModel>) {
        offerListData += offer
    }

    override fun saveUserData(userSaved: Array<User>) {
        userListData += userSaved
    }

    companion object {
        var offerListData: MutableList<OfferModel> = mutableListOf()
        var userListData: MutableList<User> = mutableListOf()
    }
}