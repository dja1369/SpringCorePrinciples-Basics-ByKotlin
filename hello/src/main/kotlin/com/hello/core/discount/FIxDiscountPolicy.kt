package com.hello.core.discount

import com.hello.core.member.Grade
import com.hello.core.member.Member
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("fixDiscountPolicy")
class FIxDiscountPolicy : DiscountPolicy {
    private val discountFixAmount = 1000 // 할인 값
    override fun discount(member: Member, price: Int): Int {
        return if (member.grade === Grade.VIP) { // enum 은 동일성 비교를 해야함 코틀린은 ===이 동일성 비교임 ==은 동등성 비교임 또한 enum 은 단일 인스턴스 이므로 ==과 ===의 결과가 같음 equals 는 내부적으로 JAVA(==) 을 사용하기에
            return discountFixAmount
        } else {
            0
        }
    }
}