package com.hello.core.member

class MemberRepositoryImpl : MemberRepository {
    private val memberRepository: MemberRepository = MemoryMemberRepository()

    override fun save(member: Member) {
        memberRepository.save(member)
    }

    override fun findById(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}