package com.hello.core.web

import com.hello.core.common.MyLogger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.ObjectProvider
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogDemoController(
    private val logDemoService: LogDemoService,
    private val myLoggerProvider: ObjectProvider<MyLogger>,
) {
    @RequestMapping("log-demo")
    fun logDemo(request: HttpServletRequest): String {
        val myLogger = myLoggerProvider.getObject()
        val requestUrl = request.requestURL.toString()
        myLogger.requestUrl = requestUrl

        myLogger.log("controller test")
        logDemoService.logic("testId")

        return "OK"
    }

}