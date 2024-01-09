package com.example.dddpractice.domain

sealed interface MemberCompanyGoodsCode {

    companion object {
        private const val FORMAT = "^[A-Z]{4}-[0-9]{4}"
        fun new(value: String?): MemberCompanyGoodsCode {
            if (value.isNullOrBlank()) throw IllegalArgumentException("加盟店企業商品コードを入力してください。")
            if (!value.matches(Regex(FORMAT))) throw IllegalArgumentException("加盟店企業商品コードは${FORMAT}の形式でなければなりません。")

            return MemberCompanyGoodsCodeImpl(value)
        }
    }

    fun value(): String

    private data class MemberCompanyGoodsCodeImpl(val value: String) : MemberCompanyGoodsCode {
        override fun value(): String {
            return this.value
        }
    }
}