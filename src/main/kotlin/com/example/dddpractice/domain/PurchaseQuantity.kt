package com.example.dddpractice.domain

sealed interface PurchaseQuantity {

    companion object {
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 100_000
        fun new(value: Int): PurchaseQuantity {
            if (value < MINIMUM_VALUE) throw IllegalArgumentException("購入数は${MINIMUM_VALUE}以上の整数でなければなりません。")
            if (MAXIMUM_VALUE < value) throw IllegalArgumentException("購入数は${MAXIMUM_VALUE}以下の整数でなければなりません。")

            return PurchaseQuantityImpl(value)
        }
    }

    fun value(): Int

    private data class PurchaseQuantityImpl(val value: Int) : PurchaseQuantity {
        override fun value(): Int {
            return value
        }
    }
}