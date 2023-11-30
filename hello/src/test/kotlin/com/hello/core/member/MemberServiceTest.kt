package com.hello.core.member

import com.hello.core.AppConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private lateinit var memberService: MemberService
//    private val memberService: MemberService = MemberServiceImpl()

    @BeforeEach
    fun beforeEach(){
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }
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