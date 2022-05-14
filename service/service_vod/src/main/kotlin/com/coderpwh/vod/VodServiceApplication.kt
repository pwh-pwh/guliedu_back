package com.coderpwh.vod

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan


/**
 * @author coderpwh
 * @date 2022/5/7 3:29 PM
 */
@EnableFeignClients
@ComponentScan(basePackages = arrayOf("com.coderpwh"))
@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
class VodServiceApplication

fun main(array: Array<String>) {
    runApplication<VodServiceApplication>(*array)
}