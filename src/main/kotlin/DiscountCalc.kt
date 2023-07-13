private const val MasterCardAndMaestroFee = 0.006
private const val MasterCardAndMaestroMinFee = 20
private const val VisaAndMirFee = 0.0075
private const val VisaAndMirMinFee = 35
private const val basicFee = 0

class DiscountCalc {

    fun calcDiscountByCardType(amount: Int, transfer: Int = 0, card: String = "VKPay"): Int {
        val previousTransfers = amount + transfer

        var totalDiscount = 0
        if (card == "MasterCard") totalDiscount = MasterAndMAestroCalculate(previousTransfers)
        if (card == "Maestro") totalDiscount = MasterAndMAestroCalculate(previousTransfers)
        if (card == "Visa") totalDiscount = VisaAndMirCalculate(previousTransfers)
        if (card == "Mir") totalDiscount = VisaAndMirCalculate(previousTransfers)
        if (card !="MasterCard" && card !="Maestro"
            && card != "Visa" && card != "Mir"
        ) totalDiscount = MasterAndMAestroCalculate(previousTransfers)

        return totalDiscount
    }

    fun MasterAndMAestroCalculate(previousTransfers: Int): Int {
        val master: Int = when {
            previousTransfers <= 75_000 -> basicFee
            else -> (previousTransfers * MasterCardAndMaestroFee + MasterCardAndMaestroMinFee).toInt()
        }
        return master
    }

    fun VisaAndMirCalculate(previousTransfers: Int): Int {
        val visa: Int = when {
            previousTransfers * VisaAndMirFee > VisaAndMirMinFee -> (previousTransfers * VisaAndMirFee).toInt()
            else -> VisaAndMirMinFee
        }
        return visa
    }
}