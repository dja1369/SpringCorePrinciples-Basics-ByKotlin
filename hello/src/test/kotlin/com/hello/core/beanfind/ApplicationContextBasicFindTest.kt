package com.hello.core.beanfind

import com.hello.core.AppConfig
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회 ")
    fun findBeanByName() {
        val memberService = ac.getBean("memberService", MemberService::class.java)
        println("memberService = ${memberService}")
        println("memberService.class() = ${memberService.javaClass}")
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
            }

    @Test
    @DisplayName("빈 타입으로 조회 ")
    fun findBeanByType() {
        val memberService = ac.getBean(MemberService::class.java)
        println("memberService = ${memberService}")
        println("memberService.class() = ${memberService.javaClass}")
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회 ")
    fun findBeanByName2() {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        println("memberService = ${memberService}")
        println("memberService.class() = ${memberService.javaClass}")
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }


    @Test
    @DisplayName("빈 이름으로 조회가 안되면 ")
    fun findBeanByNameX() {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException::class.java) {
            ac.getBean("XXXX", MemberService::class.java)
        }
    }

}


