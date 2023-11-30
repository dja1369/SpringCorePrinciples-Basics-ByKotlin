package com.hello.core


import com.hello.core.discount.DiscountPolicy
import com.hello.core.discount.FIxDiscountPolicy
import com.hello.core.discount.RateDiscountPolicy
import com.hello.core.member.*
import com.hello.core.order.OrderService
import com.hello.core.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun memberService(): MemberService = MemberServiceImpl(memberRepository())
//    fun memberService(): MemberService = MemberServiceImpl(MemoryMemberRepository()) 역활이 드러나지 않아 좋지 않음
    @Bean
    fun orderService(): OrderService = OrderServiceImpl(memberRepository(), discountPolicy())

    @Bean
    fun memberRepository(): MemberRepository = MemoryMemberRepository() // 어떤것이 들어갈지는 여기서 결정 역활이 드러남

//    fun discountPolicy(): DiscountPolicy = FIxDiscountPolicy()
    @Bean
    fun discountPolicy(): DiscountPolicy = RateDiscountPolicy() // 유연한 교체 가능

}
