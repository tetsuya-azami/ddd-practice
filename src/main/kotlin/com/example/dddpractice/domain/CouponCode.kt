package com.example.dddpractice.domain

sealed interface CouponCode {

    companion object {
        private const val FORMAT = "^[0-9]{4}[0-9]{4}$"
        fun new(value: String?): CouponCode {
            if (value.isNullOrBlank()) throw IllegalArgumentException("クーポンコードを入力してください。")
            if (!value.matches(Regex(FORMAT))) throw IllegalArgumentException("クーポンコードは${FORMAT}の形式で入力してください。")

            return CouponCodeImpl(value)
        }
    }

    fun value(): String

    private data class CouponCodeImpl(val value: String) : CouponCode {
        override fun value(): String {
            return this.value
        }
    }
}