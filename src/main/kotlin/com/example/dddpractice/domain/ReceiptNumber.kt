package com.example.dddpractice.domain

sealed interface ReceiptNumber {

    companion object {
        private const val FORMAT = "^[A-Z]{4}[0-9]{4}$"
        fun new(value: String?): ReceiptNumber {
            if (value.isNullOrBlank()) {
                throw IllegalArgumentException("レシート番号を入力してください。")
            }
            if (!value.matches(Regex(FORMAT))) {
                throw IllegalArgumentException("レシート番号は${FORMAT}の形式で入力してください。")
            }

            return ReceiptNumberImpl(value)
        }
    }

    private data class ReceiptNumberImpl(val value: String) : ReceiptNumber
}