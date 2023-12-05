package com.hello.core.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {
    @Test
    fun lifeCycleTest() {
        val ac: ConfigurableApplicationContext = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
//        val networkClient: NetworkClient = ac.getBean(NetworkClient::class.java)
//        val networkClient: NetworkClientInitializingBean = ac.getBean(NetworkClientInitializingBean::class.java)
//        val networkClient: NetworkClientMethod = ac.getBean(NetworkClientMethod::class.java)
        val networkClient: NetworkClientAnnotation = ac.getBean(NetworkClientAnnotation::class.java)
        ac.close()
    }

    companion object {
        @Configuration
        class LifeCycleConfig {
            //            @Bean
//            fun networkClient(): NetworkClient {
//                val networkClient = NetworkClient()
//                networkClient.setUrl("http://hello-spring.dev")
//                return networkClient
//            }
//            @Bean
//            fun networkClient(): NetworkClientInitializingBean {
//                val networkClient = NetworkClientInitializingBean()
//                networkClient.setUrl("http://hello-spring.dev")
//                return networkClient
//            }
//            @Bean(initMethod = "init", destroyMethod = "close")
//            fun networkClient(): NetworkClientMethod {
//                val networkClient = NetworkClientMethod()
//                networkClient.setUrl("http://hello-spring.dev")
//                return networkClient
//            }
            @Bean
            fun networkClient(): NetworkClientAnnotation {
                val networkClient = NetworkClientAnnotation()
                networkClient.setUrl("http://hello-spring.dev")
                return networkClient
            }
        }
    }
}