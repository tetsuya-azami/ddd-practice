package com.example.dddpractice.domain

sealed interface Point {

    companion object {
        fun new(value: Long): Point {
            if (value < 0) throw IllegalArgumentException("ポイント額は正の整数でなければなりません。")

            return PointImpl(value)
        }
    }

    fun value(): Long

    private data class PointImpl(val value: Long) : Point {
        override fun value(): Long {
            return this.value
        }
    }
}