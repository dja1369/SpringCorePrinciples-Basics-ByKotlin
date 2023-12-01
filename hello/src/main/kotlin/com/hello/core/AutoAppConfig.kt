package com.hello.core

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    excludeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Configuration::class])]
    // 기존 코드를 남기기 위해 사용
)
class AutoAppConfig {
}