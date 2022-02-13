package com.coderpwh.oss.service.impl

import com.coderpwh.oss.service.OssService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource


@SpringBootTest
class OssServiceImplTest {
    @Resource
    lateinit var ossService: OssService
    @Test
    fun testUploadFile() {
        if (ossService is OssServiceImpl) {
            (ossService as OssServiceImpl).uploadLocalFile()
        }
    }
}