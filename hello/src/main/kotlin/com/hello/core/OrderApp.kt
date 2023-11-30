package com.hello.core

import com.hello.core.member.Grade
import com.hello.core.member.Member
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import com.hello.core.order.Order
import com.hello.core.order.OrderService
import com.hello.core.order.OrderServiceImpl

fun main() {
    val appConfig = AppConfig()
//    val memberService: MemberService = MemberServiceImpl() // DI 주입으로 인해 변경
    val memberService: MemberService = appConfig.memberService()
//    val orderService: OrderService = OrderServiceImpl()
    val orderService: OrderService = appConfig.orderService()

    val member = Member(1, "memberA", Grade.VIP)
    memberService.join(member)
    val order: Order = orderService.createOrder(member.id, "itemA", 10000)
    println("order = ${order}")
//    println("order.calculatePrice = ${order.calculatePrice()}")
}