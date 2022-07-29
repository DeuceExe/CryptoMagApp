package CryptoMag.model

data class OfferModel(
    val sellerName: String,
    val sellQuantity: Double,
    val sellPrice: Double,
    var sellerWallet: Double,
    var sellerCryptoWallet: Double
)