package com.example.dddpractice.domain

sealed interface MemberCode {

    companion object {
        private const val FORMAT = "^[A-Z]{4}[0-9]{4}$"
        fun new(value: String?) {
            if (value.isNullOrBlank()) throw IllegalArgumentException("会員コードを入力してください。")
            if (!value.matches(Regex(FORMAT))) throw IllegalArgumentException("会員コードは${FORMAT}の形式で入力してください。")
        }
    }

    fun value(): String

    private data class MemberCodeImpl(val value: String) : MemberCode {
        override fun value(): String {
            return this.value
        }
    }
}