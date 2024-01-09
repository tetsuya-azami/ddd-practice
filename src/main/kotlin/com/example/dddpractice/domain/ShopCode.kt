package com.example.dddpractice.domain

sealed interface ShopCode {
    companion object {
        private const val FORMAT = "^[0-9]{4}[0-9]{4}[0-9]{4}"
        fun new(value: String?): ShopCode {
            if (value.isNullOrBlank()) {
                throw IllegalArgumentException("店舗コードを入力してください。")
            }

            if (!value.matches(Regex(FORMAT))) {
                throw IllegalArgumentException("店舗コードは${FORMAT}の形式で入力してください。")
            }

            return ShopCodeImpl(value)
        }
    }

    private data class ShopCodeImpl(val value: String) : ShopCode
}