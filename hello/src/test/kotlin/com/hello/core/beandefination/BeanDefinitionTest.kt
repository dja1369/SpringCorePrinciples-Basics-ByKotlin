package com.hello.core.beandefination

import com.hello.core.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext

class BeanDefinitionTest {
//    val ac: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java) // ApplicationContext 는 GetBeanDefinition() 메서드가 없다.
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    val xac = GenericXmlApplicationContext("appConfig.xml")

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    fun findApplicationBeanMetaData(){
        val beanDefinitionNames = ac.beanDefinitionNames
        beanDefinitionNames.forEach {beanDefinitionName ->
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION){
                println("beanDefinitionName = ${beanDefinitionName}" +
                        "beanDefinition = ${beanDefinition}"
                )
            }
        }
    }
    @Test
    @DisplayName("XML 빈 설정 메타정보 확인 ")
    fun findApplicationBeanMetaDataXML(){
        val beanDefinitionNames = xac.beanDefinitionNames
        beanDefinitionNames.forEach {beanDefinitionName ->
            val beanDefinition = xac.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION){
                println("beanDefinitionName = ${beanDefinitionName}" +
                        "beanDefinition = ${beanDefinition}"
                )
            }
        }
    }
}