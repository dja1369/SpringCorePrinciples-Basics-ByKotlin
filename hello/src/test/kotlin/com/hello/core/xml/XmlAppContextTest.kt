package com.hello.core.xml

import com.hello.core.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext

class XmlAppContextTest {
    lateinit var ac: ApplicationContext

    @BeforeEach
    fun beforeEach() {
        ac = GenericXmlApplicationContext("appConfig.xml")
    }

    @Test
    @DisplayName("xml 파일을 읽어들여서 테스트 ")
    fun xmlAppContext() {
        val memberService: MemberService = ac.getBean("memberService", MemberService::class.java)
        Assertions.assertThat(memberService).isInstanceOf(MemberService::class.java)
    }

}