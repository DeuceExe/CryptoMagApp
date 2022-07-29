package CryptoMag.listener

import CryptoMag.model.OfferModel

interface Offer {
    fun saveOffer(offer: Array<OfferModel>)
}