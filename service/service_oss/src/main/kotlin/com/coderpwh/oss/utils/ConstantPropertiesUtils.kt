package com.coderpwh.oss.utils

import org.apache.tomcat.util.bcel.Const
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ConstantPropertiesUtils {
    companion object {
        lateinit var accessKey:String
        lateinit var secretKey:String
        lateinit var bucket:String
    }

    @Value("\${qiniu.oss.bucket}")
    fun setBucket(bucket:String) {
        ConstantPropertiesUtils.bucket = bucket
    }
    @Value("\${qiniu.oss.accesskey}")
    fun setAccessKey(accessKey:String) {
        ConstantPropertiesUtils.accessKey = accessKey
    }

    @Value("\${qiniu.oss.secretkey}")
    fun setSecretKey(secretKey:String) {
        ConstantPropertiesUtils.secretKey = secretKey
    }


}