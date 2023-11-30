package com.hello.core.order

import com.hello.core.AppConfig
import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {

    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach(){
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

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