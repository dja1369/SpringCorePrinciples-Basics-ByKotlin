package com.hello.core.scan

import com.hello.core.AutoAppConfig
import com.hello.core.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {

    @Test
    fun basicScan() {
        val basePackageClasses = AutoAppConfig::class.java
        println("basePackageClasses = ${basePackageClasses}")
        val ac = AnnotationConfigApplicationContext(basePackageClasses)
        val memberService = ac.getBean("memberService", MemberService::class.java)

        Assertions.assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}