package com.coderpwh.eduservice.config

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@MapperScan("com.coderpwh.eduservice.mapper")
class MybatisPlusConfig {

    @Bean
    fun mybatisPlusInterceptor():MybatisPlusInterceptor {
        var mybatisPlusInterceptor = MybatisPlusInterceptor()
        mybatisPlusInterceptor.addInnerInterceptor(PaginationInnerInterceptor())
        return mybatisPlusInterceptor
    }
}