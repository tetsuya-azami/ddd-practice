package com.example.dddpractice.domain

class PaymentMethod private constructor(
    val paymentMethodCode: PaymentMethodCode,
    val paymentAmount: PaymentAmount
) {
    companion object {
        fun new(
            paymentMethodCode: PaymentMethodCode,
            paymentAmount: PaymentAmount
        ): PaymentMethod {
            return PaymentMethod(paymentMethodCode, paymentAmount)
        }
    }
}
