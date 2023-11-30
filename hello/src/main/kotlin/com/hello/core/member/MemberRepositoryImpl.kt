package com.hello.core.member

class MemberRepositoryImpl(private val memberRepository: MemberRepository) : MemberRepository {
//    private lateinit var memberRepository: MemberRepository

    override fun save(member: Member) {
        memberRepository.save(member)
    }

    override fun findById(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}