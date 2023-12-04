package com.hello.core.scan.filter

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

class ComponentFilterAppConfigTest {

    @Test
    @DisplayName("필터 테스트")
    fun filterTest() {
        val ac: ApplicationContext = AnnotationConfigApplicationContext(MyFilterAppConfig::class.java)
        val beanA = ac.getBean("beanA", BeanA::class.java)
        Assertions.assertThat(beanA).isNotNull

        org.junit.jupiter.api.Assertions.assertThrows(
            org.springframework.beans.factory.NoSuchBeanDefinitionException::class.java
        ) {
            ac.getBean("beanB", BeanB::class.java)
        }

    }
    @Configuration
    @ComponentScan(
        includeFilters = [
            ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [MyIncludeComponent::class])
        ],
        excludeFilters = [
            ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [MyExcludeComponent::class])
        ]
    )
    class MyFilterAppConfig {
    }


}