package com.example.dddpractice.domain

import java.time.LocalDate

sealed interface PaymentDate {

    companion object {
        fun new(value: LocalDate?): PaymentDate {
            val now = LocalDate.now()
            if (value == null) {
                throw IllegalArgumentException("支払日を入力してください。")
            }
            if (value.isAfter(now)) {
                throw IllegalArgumentException("支払日は未来日にはできません。")
            }
            return PaymentDateImpl(value)
        }
    }

    fun value(): LocalDate

    private data class PaymentDateImpl(val value: LocalDate) : PaymentDate {
        override fun value(): LocalDate {
            return this.value
        }
    }
}