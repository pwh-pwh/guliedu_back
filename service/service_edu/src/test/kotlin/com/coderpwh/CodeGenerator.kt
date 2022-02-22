package com.coderpwh

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.OutputFile
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.rules.DateType
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine
import java.util.*

fun main(args: Array<String>) {
    FastAutoGenerator.create(
        "jdbc:mysql://159.75.211.245:3306/guli?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
        "root",
        "123456"
    )
        .globalConfig { builder: GlobalConfig.Builder ->
            builder.author("coderpwh") // 设置作者
                .enableSwagger() // 开启 swagger 模式
                .enableKotlin()
                .fileOverride() // 覆盖已生成文件
                .dateType(DateType.ONLY_DATE)
                .outputDir("/home/pwh/IdeaProjects/xueyuan/xueyuan-parent/service/service_edu/src/main/kotlin") // 指定输出目录
        }
        .packageConfig { builder: PackageConfig.Builder ->
            builder.parent("com.coderpwh") // 设置父包名
                .moduleName("eduservice") // 设置父包模块名
                .pathInfo(
                    Collections.singletonMap(
                        OutputFile.mapperXml,
                        "/home/pwh/IdeaProjects/xueyuan/xueyuan-parent/service/service_edu/src/main/resources/mapper"
                    )
                ) // 设置mapperXml生成路径
        }
        .strategyConfig { builder: StrategyConfig.Builder ->
            builder.addInclude("edu_course","edu_course_description","edu_chapter","edu_video") // 设置需要生成的表名
                .entityBuilder()
                .idType(IdType.ASSIGN_ID)
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle()
        }
        .templateEngine(VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute()
}