package com.hello.core

import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService: MemberService = applicationContext.getBean("memberService", MemberService::class.java)

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)
    val findMember: Member = memberService.findMember(1L) ?: throw Exception("Member not found")
    println("new member = ${member.name}")
    println("find Member = ${findMember.name}")
}