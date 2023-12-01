package com.hello.core.discount

import com.hello.core.member.Grade
import com.hello.core.member.Member
import org.springframework.stereotype.Component

@Component
class RateDiscountPolicy: DiscountPolicy {
    private val discountPercent = 10
    override fun discount(member: Member, price: Int): Int {
        return if (member.grade === Grade.VIP) {
            return price * discountPercent / 100
        } else 0
    }

}