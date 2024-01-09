package com.example.dddpractice.domain

enum class PaymentMethodCode(val value: String) {
    CASH("1"),
    CREDIT("2"),
    QR("3"),
    OTHER("4");

    companion object {
        fun fromValue(value: String): PaymentMethodCode {
            return entries.firstOrNull { it.value == value } ?: OTHER
        }
    }
}