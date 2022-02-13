package com.coderpwh.oss

import com.coderpwh.oss.utils.ConstantPropertiesUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import javax.annotation.Resource

@ComponentScan(basePackages = arrayOf("com.coderpwh"))
@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
class OssServiceApplication

fun main(args: Array<String>) {
    runApplication<OssServiceApplication>(*args)
}
