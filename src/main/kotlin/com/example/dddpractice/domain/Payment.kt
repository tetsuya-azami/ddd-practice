package com.example.dddpractice.domain

class Payment(
    val receiptNumber: ReceiptNumber,
    val paymentDate: PaymentDate,
    val paymentAmount: PaymentAmount,
    val paymentMember: PaymentMember,
    val shopCode: ShopCode,
    val couponCode: CouponCode?,
    val paymentMethod: List<PaymentMethod>,
    val paymentPurchase: List<PaymentPurchase>
) {
    init {
        if (paymentAmount != paymentMethod.sumOf { it.paymentAmount.value() }) throw IllegalArgumentException("支払い金額と購入金額が不整合です。")
        if (paymentAmount.value() != paymentPurchase.sumOf { it.paymentAmount().value() }) {
            throw IllegalArgumentException("支払い金額と購入金額が不整合です。")
        }
    }
}

fun main() {
    val receiptNumber1 = ReceiptNumber.new("AAAA0000")
    val receiptNumber2 = ReceiptNumber.new("AAAA0000")

    println(receiptNumber1 === receiptNumber2)
}