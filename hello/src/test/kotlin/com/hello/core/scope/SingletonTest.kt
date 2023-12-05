package com.hello.core.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonTest {

    @Test
    fun singletonBeanFind() {
        //given
        val ac = AnnotationConfigApplicationContext(SingletonService::class.java)

        val singletonService1 = ac.getBean(SingletonService::class.java)
        val singletonService2 = ac.getBean(SingletonService::class.java)
        println("singletonService1 = $singletonService1")
        println("singletonService2 = $singletonService2")

        Assertions.assertThat(singletonService1).isSameAs(singletonService2)
        ac.close()
    }

    companion object {
        @Scope("singleton")
        class SingletonService private constructor() {
            @PostConstruct
            fun init () = println("싱글톤 객체 생성")

            fun logic(): String = "싱글톤 객체 로직 호출"

            @PreDestroy
            fun close() = println("싱글톤 객체 소멸")
        }
    }
}