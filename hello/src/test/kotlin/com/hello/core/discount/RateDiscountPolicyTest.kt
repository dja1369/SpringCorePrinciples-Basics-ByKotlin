package com.hello.core.discount

import com.hello.core.member.Grade
import com.hello.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RateDiscountPolicyTest {
    private val rateDiscountPolicy: DiscountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    fun vipMustDiscount(){
        //given
        val member = Member(1, "memberVIP", Grade.VIP)

        //when
        val discount = rateDiscountPolicy.discount(member, 10000)

        //then
        assertThat(discount).isEqualTo(1000)
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    fun notVipMustNotDiscount(){
        //given
        val member = Member(2, "memberBASIC", Grade.BASIC)

        //when
        val discount = rateDiscountPolicy.discount(member, 10000)

        //then
//        Assertions.assertThat(discount).isEqualTo(1_000) // 실패함
        assertThat(discount).isEqualTo(0)
    }
}