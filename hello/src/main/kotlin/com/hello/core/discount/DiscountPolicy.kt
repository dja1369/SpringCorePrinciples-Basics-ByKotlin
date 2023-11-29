package com.hello.core.discount

import com.hello.core.member.Member

interface DiscountPolicy {

    fun discount(member: Member, price: Int): Int
}