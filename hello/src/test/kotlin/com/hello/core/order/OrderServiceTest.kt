package com.hello.core.order

import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private val memberService: MemberService = MemberServiceImpl()
    private val orderService: OrderService = OrderServiceImpl()

    @Test
    fun createOrder() {
        //given
        val member = Member(1L, "memberA", Grade.VIP)

        //when
        memberService.join(member)
        orderService.createOrder(member.id, "itemA", 10000)

        //then
        Assertions.assertThat(orderService.createOrder(member.id, "itemA", 10000).discountPrice).isEqualTo(1000)
    }
}