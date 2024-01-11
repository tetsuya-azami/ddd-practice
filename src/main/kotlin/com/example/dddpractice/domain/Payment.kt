package com.example.dddpractice.domain

// Paymentは集約ルート。
// 集約に対する操作は必ず集約ルートを経由して行われる。
class Payment(
    val receiptNumber: ReceiptNumber,
    private val paymentDate: PaymentDate,
    private val paymentAmount: PaymentAmount,
    private val paymentMember: PaymentMember,
    private val shopCode: ShopCode,
    private val couponCode: CouponCode?,
    private val paymentMethod: List<PaymentMethod>,
    private val paymentPurchase: List<PaymentPurchase>
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