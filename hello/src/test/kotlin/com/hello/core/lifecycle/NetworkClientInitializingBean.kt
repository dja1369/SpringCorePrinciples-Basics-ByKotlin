package com.hello.core.lifecycle

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class NetworkClientInitializingBean: InitializingBean, DisposableBean {
    private var url: String? = null
    init {
        println("생성자 호출, url = $url")
    }

    fun setUrl(url: String) {
        this.url = url
    }
    private fun call(s: String) {
        println("call: $url message = $s")
    }
    // 서비스 시작시 호출
    private fun connect() {
        println("connect: $url")
    }
    // 서비스 종료시 호출
    private fun disconnect() {
        println("close: $url")
    }

    /**
     * Invoked by the containing `BeanFactory` after it has set all bean properties
     * and satisfied [BeanFactoryAware], `ApplicationContextAware` etc.
     *
     * This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     * @throws Exception in the event of misconfiguration (such as failure to set an
     * essential property) or if initialization fails for any other reason
     */
    // InitializingBean 의 afterPropertiesSet() 메서드를 오버라이드 하여 초기화 코드를 작성 할 수 있다.
    // 객체 생성이후 동작할 로직 작성
    override fun afterPropertiesSet() {
        connect()
        call("초기화 연결 메시지")
    }
    /**
     * Invoked by the containing `BeanFactory` on destruction of a bean.
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     * but not rethrown to allow other beans to release their resources as well.
     */
    // DisposableBean 의 destroy() 메서드를 오버라이드 하여 소멸 코드를 작성 할 수 있다.
    // 객체가 소멸되기 직전 동작할 로직 작성
    override fun destroy() {
        println("NetworkClient.destroy")
        disconnect()
    }
}