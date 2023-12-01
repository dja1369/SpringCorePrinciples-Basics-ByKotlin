package com.hello.core.member

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class MemoryMemberRepository: MemberRepository {
    companion object {
        private val store = HashMap<Long, Member>()
//        val test = ConcurrentHashMap<Long, Member>() // 동시성 이슈가 있기에 ConcurrentHashMap 을 쓰는게 좋다.
    }
    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member? {
        return store[memberId]
    }
}