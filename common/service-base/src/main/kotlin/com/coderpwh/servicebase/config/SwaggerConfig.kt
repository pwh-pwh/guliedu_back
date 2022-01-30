package com.coderpwh.servicebase.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.function.Predicate

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun webApiConfig(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("webApi")
            .apiInfo(webApiInfo())
            .select()
            .paths(Predicate.not(PathSelectors.regex("/admin/.*")))
            .build()
    }

    fun webApiInfo():ApiInfo {
       return ApiInfoBuilder()
            .title("api文档")
            .description("微服务接口定义")
            .version("1.0")
            .contact(Contact("coderpwh","coderpwh.com","2145865322@qq.com"))
            .build()
    }
}