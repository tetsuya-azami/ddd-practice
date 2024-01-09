package com.example.dddpractice.domain

import java.math.BigDecimal

class PaymentMethod private constructor(
    val paymentMethodCode: PaymentMethodCode,
    val paymentAmount: PaymentAmount,
    private val grantPoint: Point
) {
    companion object {
        private const val PAYMENT_METHOD_POINT_RATE = 0.5
        fun new(
            paymentMethodCode: PaymentMethodCode,
            paymentAmount: PaymentAmount
        ): PaymentMethod {
            val grantPoint = paymentAmount.value().multiply(BigDecimal.valueOf(PAYMENT_METHOD_POINT_RATE)).toLong()

            return PaymentMethod(paymentMethodCode, paymentAmount, Point.new(grantPoint))
        }
    }
}
