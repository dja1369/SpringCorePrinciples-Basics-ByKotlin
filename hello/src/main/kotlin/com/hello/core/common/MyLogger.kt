package com.hello.core.common

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(value = "request")
class MyLogger{
    lateinit var uuid: String
    lateinit var requestUrl: String
    fun log(message: String?) {
        println("[$uuid] [$requestUrl] $message")
    }
    @PostConstruct
    fun init() {
        uuid = java.util.UUID.randomUUID().toString()
        println("[$uuid] request scope bean create: $this")
    }

    @PreDestroy
    fun close() {
        println("[$uuid] request scope bean close: $this")
    }
}