package com.hello.core.member

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private val memberService: MemberService = MemberServiceImpl()
    @Test
    fun join(){
        //given
        val member: Member = Member(1L, "memberA", Grade.VIP)

        //when
        memberService.join(member)
        val findMember: Member = memberService.findMember(1L) ?: throw Exception("Member not found")

        //then
        Assertions.assertThat(member).isEqualTo(findMember)
    }
}