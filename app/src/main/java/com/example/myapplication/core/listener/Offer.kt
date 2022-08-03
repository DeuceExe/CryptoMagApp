package com.example.myapplication.core.listener

import com.example.myapplication.core.model.OfferModel

interface Offer {

    fun saveOffer(offer: Array<OfferModel>)
}