package com.hello.core.lifecycle

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy

class NetworkClientAnnotation {
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

    @PostConstruct
    fun start() {
        println("NetworkClient.init")
        connect()
        call("초기화 연결 메시지")
    }

    @PreDestroy
    fun close() {
        println("NetworkClient.close")
        disconnect()
    }
}