fun main(args: Array<String>) {
    println("Введите сумму перевода")
    val amount = readln().toInt()
//    printDiscount(
//        amount,
//        DiscountCalc().calcDiscountByCardType(amount)
//    )
//    printDiscount(
//        amount,
//        DiscountCalc().calcDiscountByCardType(amount, card = "Visa")
//    )
//    printDiscount(
//        amount,
//        DiscountCalc().calcDiscountByCardType(amount, 77000, card = "MasterCard")
//    )
//    printDiscount(
//        amount,
//        DiscountCalc().calcDiscountByCardType(amount, 77000, card = "Visa")
//    )

    printDiscount(
        amount,
        DiscountCalc().calcDiscountByCardType(amount, 100, card = "Visa")
    )
}

fun printDiscount(amount: Int, resultFee: Int) {
    print("Сумма перевода: $amount\nРазмер комиссии составит: $resultFee")
}

