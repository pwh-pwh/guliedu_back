package com.coderpwh.vod.util

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


/**
 * @author coderpwh
 * @date 2022/5/7 3:45 PM
 */
@Component
class VodConstantPropertiesUtil:InitializingBean {
    @Value("\${aliyun.vod.file.keyid}")
    lateinit var keyId:String
    @Value("\${aliyun.vod.file.keysecret}")
    lateinit var keySecret:String
    override fun afterPropertiesSet() {
        key = keyId
        secret = keySecret
    }
    companion object {
        lateinit var key:String
        lateinit var secret:String
    }
}
