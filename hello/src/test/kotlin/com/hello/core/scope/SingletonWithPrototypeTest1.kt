package com.hello.core.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope
import javax.inject.Provider


class SingletonWithPrototypeTest1 {
    @Test
    fun prototypeFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)
        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        prototypeBean1.addCount()
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1)

        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)
        prototypeBean2.addCount()
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1)
    }

    @Test
    fun singletonClientUsePrototype() {
        val ac = AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)
        val clientBean1 = ac.getBean(ClientBean::class.java)
        val count1 = clientBean1.logic()
        Assertions.assertThat(count1).isEqualTo(1)

        val clientBean2 = ac.getBean(ClientBean::class.java)
        val count2 = clientBean2.logic()
        // 클라이언트 빈은 싱글톤이고 프로토타입 빈은 생성시에만 매번 새로 생성되는것이기에 싱글톤 에서 프로토타입의 빈을 건드리면 새로 생성되는것이 아니기에 이미 생성되 주입되어 있는 프로토 타입 빈의 속성값을 증가시키된다
        // 그래서 1이 아닌 2가 나온다.
        Assertions.assertThat(count2).isEqualTo(2)
    }

    companion object {
        @Scope("singleton")
//        class ClientBean(private val prototypeBeanProvider: ObjectProvider<PrototypeBean>) { // 스프링에 의존적 코드
        class ClientBean(private val prototypeBeanProvider: Provider<PrototypeBean>) {

            fun logic(): Int {
//                val prototypeBean = prototypeBeanProvider.getObject() // 스프링에 의존적 코드
                val prototypeBean = prototypeBeanProvider.get()
                prototypeBean.addCount()
                return prototypeBean.getCount()
            }
        }
//        @Scope("singleton")
//        class ClientBean(private val prototypeBean: PrototypeBean) {
//
//            fun logic(): Int {
//                prototypeBean.addCount()
//                return prototypeBean.getCount()
//            }
//        }
        @Scope("prototype")
        class PrototypeBean {
            private var count: Int = 0

            fun addCount() = count++

            fun getCount(): Int = count

            @PostConstruct
            fun init() = println("PrototypeBean.init $this")

            @PreDestroy
            fun destroy() = println("PrototypeBean.destroy")
        }
    }
}