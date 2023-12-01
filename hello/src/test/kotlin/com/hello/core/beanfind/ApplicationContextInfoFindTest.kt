package com.hello.core.beanfind

import com.hello.core.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoFindTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 출력하기")
    fun findAllBean(){
        val beanDefinitionNames = ac.beanDefinitionNames
//        for (beanDefinitionName in beanDefinitionNames) {
//            val bean = ac.getBean(beanDefinitionName)
//            println("name = ${beanDefinitionName} object = ${bean}")
//        }
        beanDefinitionNames.forEach { beanDefinitionName ->
            val bean = ac.getBean(beanDefinitionName)
            println("name = ${beanDefinitionName} object = ${bean}")
        }
    }

    @Test
    @DisplayName("어플리케이션 빈 출력하기")
    fun findApplicationBean(){
        val beanDefinitionNames = ac.beanDefinitionNames
        beanDefinitionNames.forEach { beanDefinitionName ->
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION){
                val bean = ac.getBean(beanDefinitionName)
                println("name = ${beanDefinitionName} object = ${bean}")
            }
        }
    }



}