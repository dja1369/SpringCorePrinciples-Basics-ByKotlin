package com.hello.core.order

import com.hello.core.discount.DiscountPolicy
import com.hello.core.discount.FIxDiscountPolicy
import com.hello.core.discount.RateDiscountPolicy
import com.hello.core.member.Member
import com.hello.core.member.MemberRepository
import com.hello.core.member.MemoryMemberRepository

class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
): OrderService {
        // 생성자 주입으로 변경
//    private val memberRepository: MemberRepository = MemoryMemberRepository()
//    private val discountPolicy: DiscountPolicy = FIxDiscountPolicy()
//    private val discountPolicy: DiscountPolicy = RateDiscountPolicy()
//    private lateinit var discountPolicy: DiscountPolicy

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member: Member = memberRepository.findById(memberId) ?: throw IllegalStateException("회원이 없습니다.")
        val discountPrice: Int = discountPolicy.discount(member, itemPrice)
        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}