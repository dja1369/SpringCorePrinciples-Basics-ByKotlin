package com.hello.core.singleton

import com.hello.core.AppConfig
import com.hello.core.member.MemberRepository
import com.hello.core.member.MemberService
import com.hello.core.member.MemberServiceImpl
import com.hello.core.order.OrderServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {

    @Test
    fun configurationTest() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        val orderService = ac.getBean("orderService", OrderServiceImpl::class.java)
        val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

        val memberServiceMemberRepository = memberService.getMemberRepository()
        val orderServiceMemberRepository = orderService.getMemberRepository()

        // 모두 같은 인스턴스를 참조한다.
        Assertions.assertThat(memberServiceMemberRepository).isSameAs(orderServiceMemberRepository)
    }

    @Test
    fun configurationDeepTest() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
        // AppConfig 에서는 @Configuration 을 사용했기 때문에 스프링 컨테이너에 등록된다.
        // AppConfig 는 내부에 CGLIB 라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고,
        // 그 다른 클래스를 스프링 빈으로 등록한 것이다.
        // 이 임의의 다른 클래스가 바로 싱글톤이 보장되도록 해준다.
        val bean = ac.getBean(AppConfig::class.java)
        println("bean = ${bean.javaClass}")
        // bean = class com.hello.core.AppConfig$$EnhancerBySpringCGLIB$$b8b7b8f1
        // AppConfig 를 상속받은 임의의 다른 클래스가 생성되었다.
    }
}