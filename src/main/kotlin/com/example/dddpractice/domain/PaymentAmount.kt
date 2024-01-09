package com.example.dddpractice.domain

import java.math.BigDecimal

sealed interface PaymentAmount {

    companion object {
        private val MAX_VALUE = BigDecimal.valueOf(1000_000)
        fun new(value: BigDecimal?): PaymentAmount {
            if (value == null) {
                throw IllegalArgumentException("支払い総額を入力してください。")
            }
            if (value > MAX_VALUE) {
                throw IllegalArgumentException("支払い総額は1000000以下でなければなりません。")
            }
            return PaymentAmountImpl(value)
        }
    }

    public fun value(): BigDecimal = this.value()

    private data class PaymentAmountImpl(val value: BigDecimal) : PaymentAmount
}