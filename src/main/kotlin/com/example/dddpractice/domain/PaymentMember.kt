package com.example.dddpractice.domain

class PaymentMember private constructor(
    val memberCode: MemberCode,
    private val remainingPoints: Point,
    private val usePoints: Point
) {
    companion object {
        fun new(
            memberCode: MemberCode,
            remainingPoints: Point,
            usePoints: Point = Point.new(0)
        ): PaymentMember {
            return PaymentMember(memberCode, remainingPoints, usePoints)
        }
    }

    fun usePoints(point: Point): PaymentMember {
        if (remainingPoints.value() < point.value()) throw IllegalArgumentException("ポイントが不足しています。")

        return new(
            memberCode = this.memberCode,
            remainingPoints = Point.new(this.remainingPoints.value() - point.value()),
            usePoints = Point.new(this.usePoints.value() + point.value())
        )
    }
}