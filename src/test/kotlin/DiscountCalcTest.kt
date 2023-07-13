import org.junit.Assert.assertEquals
import org.junit.Test

class DiscountCalcTest {
    private val discountCalc = DiscountCalc()


    /* ТЕСТИРОВАНИЕ ЗНАЧЕНИЙ ПО УМОЛЧАНИЮ**/


    @Test
    fun calcDiscountByCardType_Default() {
        val amount = 100
        val transfer = 0

        val result = discountCalc.calcDiscountByCardType(amount, transfer)
        assertEquals(0, result)
    }

    @Test
    fun calcDiscountByCardType_Default_2() {
        val amount = 100
        val result = discountCalc.calcDiscountByCardType(amount)
        assertEquals(0, result)
    }

    @Test
    fun calcDiscountByCardType_Default_3() {
        val amount = 100
        val card = "Kiwi"

        val result = discountCalc.calcDiscountByCardType(amount, card = card)
        assertEquals(0, result)
    }


    /*ТЕСТИРОВАНИЕ ДЛЯ MasterCard и Maestro**/


    @Test
    fun calcDiscountByCardType_MasterCard() {
        val amount = 100
        val transfer = 0
        val card = "MasterCard"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(0, result)
    }

    @Test
    fun calcDiscountByCardType_MasterCard_1() {

        val result = discountCalc.calcDiscountByCardType(100_000, card = "MasterCard")
        assertEquals(620, result)
    }

    @Test
    fun calcDiscountByCardType_Maestro() {
        val amount = 100
        val transfer = 0
        val card = "Maestro"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(0, result)
    }

    @Test
    fun calcDiscountByCardType_Maestro_1() {
        val amount = 100_000
        val transfer = 0
        val card = "Maestro"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(620, result)
    }


    /*ТЕСТИРОВАНИЕ ДЛЯ Visa и Mir**/


    @Test
    fun calcDiscountByCardType_Visa() {
        val amount = 100
        val transfer = 0
        val card = "Visa"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(35, result)
    }

    @Test
    fun calcDiscountByCardType_Mir() {
        val amount = 100
        val transfer = 0
        val card = "Mir"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(35, result)
    }

    @Test
    fun calcDiscountByCardType_Mir_2() {
        val amount = 100_000
        val transfer = 0
        val card = "Mir"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(750, result)
    }


    /*ТЕСТИРОВАНИЕ ДЛЯ VKPay**/


    @Test
    fun calcDiscountByCardType_VKPay() {
        val amount = 100
        val transfer = 0
        val card = "VKPay"

        val result = discountCalc.calcDiscountByCardType(amount, transfer, card)
        assertEquals(0, result)
    }


    /*ТЕСТИРОВАНИЕ ВСПОМОГАТЕЛЬНЫХ ФУНКЦИЙ**/


    @Test
    fun masterAndMAestroCalculate() {
        val previousTransfers = 0

        val result = discountCalc.MasterAndMAestroCalculate(previousTransfers)
        assertEquals(0, result)
    }

    @Test
    fun masterAndMAestroCalculate_2() {
        val previousTransfers = 100_000

        val result = discountCalc.MasterAndMAestroCalculate(previousTransfers)
        assertEquals(620, result)
    }


    @Test
    fun visaAndMirCalculate() {
        val previousTransfers = 0
        val result = discountCalc.VisaAndMirCalculate(previousTransfers)
        assertEquals(35, result)
    }

    @Test
    fun visaAndMirCalculate_2() {

        val previousTransfers = 100_000
        val result = discountCalc.VisaAndMirCalculate(previousTransfers)
        assertEquals(750, result)
    }
}