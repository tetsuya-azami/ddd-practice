package com.example.dddpractice.domain

class PaymentMember private constructor(
    val userId: String,
    val pointBalance: Long
) {
    companion object {
        fun new(userId: String, pointBalance: Long): PaymentMember {
            return PaymentMember(userId, pointBalance)
        }
    }
}