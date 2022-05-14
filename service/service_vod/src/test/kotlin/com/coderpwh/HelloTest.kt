package com.coderpwh

import com.aliyun.vod.upload.impl.UploadVideoImpl
import com.aliyun.vod.upload.req.UploadVideoRequest
import com.aliyuncs.DefaultAcsClient
import com.aliyuncs.profile.DefaultProfile
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest
import org.junit.Test
import java.util.StringJoiner
import kotlin.test.assertEquals

class HelloTest {
    companion object {
        const val id = "LTAI5tJNEg3C2UpX7wVqTurQ"
        const val key = "QWf45WOVHj28sSKfulGcSmTdSRu4Op"
        fun init(id:String = this.id,key:String = this.key) :DefaultAcsClient{
            var regionId = "cn-shanghai"
            var profile = DefaultProfile.getProfile(regionId, id, key)
            var client = DefaultAcsClient(profile)
            return client
        }
    }
    @Test
    fun testGetVideo() {
        println("hello")
        var client = HelloTest.init()
        var req = GetPlayInfoRequest()
        req.videoId = "f4b454f769124ecebdb60917bfd4458a"
        var response = client.getAcsResponse(req)
        response.playInfoList.forEach {
            println(it.playURL)
        }
        println(response.videoBase.title)
    }
    @Test
    fun testUploadFile() {
        var uploadVideoRequest = UploadVideoRequest(id, key,"mytest","/Volumes/HIKVISION/视频/谷粒学院/项目资料【瑞客 论坛 www.ruike1.com】/1-阿里云上传测试视频/test.mp4")
        uploadVideoRequest.partSize = 1024*1024L
        uploadVideoRequest.taskNum = 2
        uploadVideoRequest.enableCheckpoint = true
        var upload = UploadVideoImpl()
        var videoResponse = upload.uploadVideo(uploadVideoRequest)
        println("req id:${videoResponse.requestId}")
        if (videoResponse.isSuccess) {
            println("$videoResponse.videoId")
        } else {
            println("${videoResponse.message}")
        }
    }
}

fun fef() {

}
val ffee = null

var aaa:String = "aaa"
const val bbb:String = "bbb"

/*fun main() {
    var client = HelloTest.init()
    var request = GetVideoPlayAuthRequest()
    request.videoId = "f4b454f769124ecebdb60917bfd4458a"
    var response = client.getAcsResponse(request)
    println(response.playAuth+"\n"+response.videoMeta.title)

}*/
