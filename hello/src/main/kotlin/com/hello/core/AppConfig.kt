package com.hello.core


import com.hello.core.discount.RateDiscountPolicy
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import com.hello.core.member.MemoryMemberRepository
import com.hello.core.order.OrderService
import com.hello.core.order.OrderServiceImpl

class AppConfig {
    fun memberService(): MemberService = MemberServiceImpl(MemoryMemberRepository())

    fun orderService(): OrderService = OrderServiceImpl(MemoryMemberRepository(), RateDiscountPolicy())


}