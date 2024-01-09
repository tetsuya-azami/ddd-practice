package com.example.dddpractice.domain

import java.math.BigDecimal

class PaymentPurchase private constructor(
    val memberCompanyGoodsCode: MemberCompanyGoodsCode,
    private val purchaseQuantity: PurchaseQuantity,
    val goodsPrice: GoodsPrice,
    private val grantPoint: Point
) {
    companion object {
        private const val PAYMENT_PURCHASE_POINT_RATE = 0.05

        fun new(
            memberCompanyGoodsCode: MemberCompanyGoodsCode,
            purchaseQuantity: PurchaseQuantity,
            goodsPrice: GoodsPrice
        ): PaymentPurchase {
            val grantPoint = (goodsPrice.value() * purchaseQuantity.value() * PAYMENT_PURCHASE_POINT_RATE).toLong()
            return PaymentPurchase(memberCompanyGoodsCode, purchaseQuantity, goodsPrice, Point.new(grantPoint))
        }

    }

    fun paymentAmount(): PaymentAmount {
        return PaymentAmount.new(BigDecimal.valueOf(goodsPrice.value() * purchaseQuantity.value()))
    }
}