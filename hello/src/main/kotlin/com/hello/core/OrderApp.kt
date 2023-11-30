package com.hello.core

import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import com.hello.core.order.Order
import com.hello.core.order.OrderService
import com.hello.core.order.OrderServiceImpl
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    // 스프링 컨테이너 생성
    // ApplicationContext 는 스프링 컨테이너 인터페이스이며 AnnotationConfigApplicationContext 는 스프링 컨테이너 구현체이다.
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService: MemberService = applicationContext.getBean("memberService", MemberService::class.java)
    val orderService: OrderService = applicationContext.getBean("orderService", OrderService::class.java)


    val member = Member(1, "memberA", Grade.VIP)
    memberService.join(member)
    val order: Order = orderService.createOrder(member.id, "itemA", 10000)
    println("order = ${order}")
//    println("order.calculatePrice = ${order.calculatePrice()}")
}