package CryptoMag.ui
import CryptoMag.Enums.TypeTransaction
import CryptoMag.Models.User


/*open class Transaction(
    transactionUserName: String,
    transactionUserWallet: Double,
    transactionUserCryptoWallet: Double,
    transactionNumber: String
){
    private var number = transactionNumber
    private val purchase = TypeTransaction.Purchase
    private val sale = TypeTransaction.Sale
    private val trade = TypeTransaction.Trade
    private val marketPrice = transactionUserWallet
    private val cryptoSell = transactionUserCryptoWallet
    private val userName = transactionUserName

    fun transactionCheck(type: TypeTransaction, userInfo: User) : Boolean{
        println("Transaction №$number between ${userInfo.userName} and $userName")
        when(type){
            purchase -> return userInfo.userWallet > marketPrice
            sale -> return userInfo.userCryptoWallet > cryptoSell
            trade -> return userInfo.userCryptoWallet == cryptoSell
        }
        return false
    }
}*/

