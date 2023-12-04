package com.hello.core.order

import com.hello.core.annotation.MainDiscountPolicy
import com.hello.core.discount.DiscountPolicy
import com.hello.core.discount.FIxDiscountPolicy
import com.hello.core.discount.RateDiscountPolicy
import com.hello.core.member.Member
import com.hello.core.member.MemberRepository
import com.hello.core.member.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class OrderServiceImpl(
    private val memberRepository: MemberRepository,
//    @Qualifier("mainDiscountPolicy") private val discountPolicy: DiscountPolicy
    @MainDiscountPolicy private val discountPolicy: DiscountPolicy // @Qualifier 대신 @MainDiscountPolicy 를 사용 컴파일시 오류를 잡기 위해서 명시적으로 선언된 어노테이션 생성
): OrderService {

//    @Autowired 스프링에선 생성자가 하나만 있으면 @Autowired 를 생략해도 자동 주입이 된다.
//    constructor(memberRepository: MemberRepository): this(memberRepository, FIxDiscountPolicy())

//    생성자 주입으로 변경
//    private val memberRepository: MemberRepository = MemoryMemberRepository()
//    private val discountPolicy: DiscountPolicy = FIxDiscountPolicy()
//    private val discountPolicy: DiscountPolicy = RateDiscountPolicy()
//    private lateinit var discountPolicy: DiscountPolicy

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member: Member = memberRepository.findById(memberId) ?: throw IllegalStateException("회원이 없습니다.")
        val discountPrice: Int = discountPolicy.discount(member, itemPrice)
        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    // 테스트 용도
    fun getMemberRepository(): MemberRepository {
        return memberRepository
    }
}