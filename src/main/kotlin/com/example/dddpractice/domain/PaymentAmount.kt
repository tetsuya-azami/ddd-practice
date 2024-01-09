package com.example.dddpractice.domain

import java.math.BigDecimal

sealed interface PaymentAmount {

    companion object {
        private val MINIMUM_VALUE = BigDecimal.valueOf(0)
        private val MAX_VALUE = BigDecimal.valueOf(1000_000)
        fun new(value: BigDecimal?): PaymentAmount {
            if (value == null) throw IllegalArgumentException("支払い総額を入力してください。")
            if (value < MINIMUM_VALUE) throw IllegalArgumentException("支払い総額は${MINIMUM_VALUE}以上の整数でなければなりません。")
            if (MAX_VALUE < value) throw IllegalArgumentException("支払い総額は${MAX_VALUE}以下でなければなりません。")

            return PaymentAmountImpl(value)
        }
    }

    fun value(): BigDecimal

    private data class PaymentAmountImpl(val value: BigDecimal) : PaymentAmount {
        override fun value(): BigDecimal {
            return value
        }
    }
}