package com.coderpwh.vod.service.impl

import com.coderpwh.vod.service.VideoService
import com.coderpwh.vod.util.VodConstantPropertiesUtil
import com.coderpwh.vod.util.uploadVideoFromIs
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


/**
 * @author coderpwh
 * @date 2022/5/7 4:38 PM
 */
@Service
class VideoServiceImpl : VideoService {
    override fun uploadVideo(file: MultipartFile): String {
        var videoId = uploadVideoFromIs(
            VodConstantPropertiesUtil.key,
            VodConstantPropertiesUtil.secret,
            file.originalFilename!!.substring(0, file.originalFilename!!.lastIndexOf('.')),
            file.originalFilename!!,
            file.inputStream
        )
        return videoId
    }

    override fun deleteVideo(videoId: String) {
        com.coderpwh.vod.util.deleteVideo(videoId)
    }
}