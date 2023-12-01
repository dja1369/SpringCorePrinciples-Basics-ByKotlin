package com.hello.core.singleton

import com.hello.core.AppConfig
import com.hello.core.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    fun pureContainer() {
        val appConfig: AppConfig = AppConfig()

        // 호출 할때 마다 객체 생성
        val memberService1 = appConfig.memberService()
        val memberService2: MemberService = appConfig.memberService()

        println("memberService1 $memberService1")
        println("memberService2 $memberService2")

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    @DisplayName("싱글톤 객체 사용")
    fun singletonServiceTest() {
        val singletonService1 = SingletonService.getInstance()
        val singletonService2 = SingletonService.getInstance()

        Assertions.assertThat(singletonService1).isEqualTo(singletonService2) // 동등성
        Assertions.assertThat(singletonService1).isSameAs(singletonService2) // 동일성
    }
}