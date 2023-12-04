package com.hello.core

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
//    basePackages = ["com.hello.core"], // 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
//    excludeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Configuration::class])]
    // 기존 코드를 남기기 위해 사용
)
class AutoAppConfig {
}