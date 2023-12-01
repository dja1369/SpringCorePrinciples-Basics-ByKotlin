package com.hello.core.singleton

// object 키워드를 사용하면 싱글톤을 쉽게 만들 수 있다.
object SingletonService  {

    fun getInstance(): SingletonService {
        return this
    }

    fun logic(){
        println("싱글톤 객체 로직 호출")
    }
}
fun main(){
    val singletonService1 = SingletonService.getInstance()
    val singletonService2 = SingletonService.getInstance()
    println("singletonService1 = ${singletonService1}")
    println("singletonService2 = ${singletonService2}")
    println("singletonService${SingletonService}")
    println(singletonService1.logic())
}