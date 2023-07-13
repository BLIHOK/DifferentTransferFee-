import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainKtTest {

    @Test
    fun testPrintDiscount() {

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        val amount = 100
        val resultFee = 10
        printDiscount(amount, resultFee)

        val expectedOutput =("Сумма перевода: $amount\nРазмер комиссии составит: $resultFee")

        assertEquals(expectedOutput, outContent.toString())
    }
}