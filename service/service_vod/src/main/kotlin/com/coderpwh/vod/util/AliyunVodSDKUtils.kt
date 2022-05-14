package com.coderpwh.vod.util

import com.aliyun.vod.upload.impl.UploadVideoImpl
import com.aliyun.vod.upload.req.UploadStreamRequest
import com.aliyuncs.DefaultAcsClient
import com.aliyuncs.profile.DefaultProfile
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest
import com.coderpwh.servicebase.exception.GuliException
import com.sun.java.accessibility.util.GUIInitializedListener
import org.slf4j.LoggerFactory
import java.io.InputStream
import kotlin.math.log


/**
 * @author coderpwh
 * @date 2022/5/7 4:10 PM
 */
const val regionId = "cn-shanghai"

/**
 * 初始化client
 */
fun initClient(key: String, secret: String): DefaultAcsClient {
    var profile = DefaultProfile.getProfile(regionId, key, secret)
    return DefaultAcsClient(profile)
}

/**
 * 从流上传视频
 */
fun uploadVideoFromIs(key: String, secret: String, title: String, fileName: String,`is`:InputStream): String {
    try {
        var uploadStreamRequest = UploadStreamRequest(key, secret, title, fileName, `is`)
        var uploadVideoImpl = UploadVideoImpl()
        var response = uploadVideoImpl.uploadStream(uploadStreamRequest)
        var videoId = response.videoId
        if (!response.isSuccess) {
            val msg = "上传错误: code:${response.code},message:${response.message}"

            if (videoId.isNullOrEmpty()) {
                throw GuliException(20001,msg)
            }
        }
        return videoId
    } catch (e: Exception) {
        throw GuliException(20001,"上传失败")
    }
}

fun deleteVideo(videoId:String) {
    try {
        var client = initClient(VodConstantPropertiesUtil.key, VodConstantPropertiesUtil.secret)
        var request = DeleteVideoRequest()
        request.videoIds = videoId
        var acsResponse = client.getAcsResponse(request)
        println("req id:${acsResponse.requestId}")
    } catch (e: Exception) {
        throw GuliException(20001,"error to delete video")
    }

}