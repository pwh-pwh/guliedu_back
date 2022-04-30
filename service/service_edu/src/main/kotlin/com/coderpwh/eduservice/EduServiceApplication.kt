package com.coderpwh.eduservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.coderpwh"])
class EduServiceApplication
fun main(args: Array<String>) {
    runApplication<EduServiceApplication>(*args)
}