package com.coderpwh.oss.service.impl

import com.coderpwh.oss.service.OssService
import com.coderpwh.oss.utils.ConstantPropertiesUtils
import com.qiniu.common.QiniuException
import com.qiniu.storage.Configuration
import com.qiniu.storage.Region
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream
import java.util.*

@Service
class OssServiceImpl :OssService{
    override fun uploadFileAvatar(file: MultipartFile):String {
//        构建日期路径
        var filePath = DateTime().toString("yyyy/MM/dd")
        var originalFilename = file.originalFilename
        var fileName = UUID.randomUUID().toString()
        var fileType = originalFilename!!.substring(originalFilename.lastIndexOf("."))
        var newName = fileName+fileType
        var fileUrl:String = filePath+"/"+ newName
        uploadFile(file.inputStream,fileUrl)
        var url:String = "http://r768n3l3z.hn-bkt.clouddn.com/" + fileUrl
        return url
    }

    private fun uploadFile(ins:InputStream,fileUrl:String) {
        val cfg = Configuration(Region.huanan())
        val uploadManager = UploadManager(cfg)
        val auth:Auth = Auth.create(
            ConstantPropertiesUtils.accessKey,
            ConstantPropertiesUtils.secretKey
        )
        var uploadToken = auth.uploadToken(
            ConstantPropertiesUtils.bucket
        )
        try {
            uploadManager.put(ins,fileUrl,uploadToken,null,null)
        }catch (ex:QiniuException) {
            println(ex)
        }

    }
    fun uploadLocalFile() {
        var byteInputStream = "hello qiniu cloud".byteInputStream()
        val key = "demo2.txt"
        uploadFile(byteInputStream,key)
    }

}