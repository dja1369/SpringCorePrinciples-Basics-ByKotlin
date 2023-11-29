package com.hello.core

import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl

fun main() {
    val memberService: MemberService = MemberServiceImpl()
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)
    val findMember: Member? = memberService.findMember(1L) ?: throw Exception("Member not found")
    println("new member = ${member.name}")
    println("find Member = ${findMember?.name}")
}