package com.example.dddpractice.domain

sealed interface GoodsPrice {
    companion object {
        fun new(value: Long): GoodsPrice {
            if (value < 0) throw IllegalArgumentException("商品価格は0以上の整数でなければなりません。")

            return GoodsPriceImpl(value)
        }
    }

    fun value(): Long

    private data class GoodsPriceImpl(val value: Long) : GoodsPrice {
        override fun value(): Long {
            return value
        }
    }
}