package com.hello.core.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class PrototypeTest {

    @Test
    fun prototypeBeanFind() {
        //given
        val ac = AnnotationConfigApplicationContext(PrototypeService::class.java)
        println("find prototypeService1")
        val prototypeService1 = ac.getBean(PrototypeService::class.java)
        println("find prototypeService2")
        val prototypeService2 = ac.getBean(PrototypeService::class.java)
        println("prototypeService1 = $prototypeService1")
        println("prototypeService2 = $prototypeService2")

        Assertions.assertThat(prototypeService1).isNotSameAs(prototypeService2)
//        prototypeService1.close() // 임의로 close 를 호출해야 한다.
        ac.close() // prototype 은 close 가 호출되지 않는다. 왜? 생성, 의존관계 주입 그리고 초기화까지만 관여하므로 소멸 메서드가 호출되지 않는다.
    }

    companion object {
        @Scope("prototype")
        class PrototypeService private constructor() {
            @PostConstruct
            fun init () = println("프로토타입 객체 생성")

            fun logic(): String = "싱글톤 객체 로직 호출"

            @PreDestroy
            fun close() = println("싱글톤 객체 소멸")
        }
    }
}