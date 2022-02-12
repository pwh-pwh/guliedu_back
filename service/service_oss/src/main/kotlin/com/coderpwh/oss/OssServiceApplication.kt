package com.coderpwh.oss

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
class OssServiceApplication
fun main(args: Array<String>) {
    runApplication<OssServiceApplication>(*args)
}