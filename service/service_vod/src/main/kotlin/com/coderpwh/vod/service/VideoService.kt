package com.coderpwh.vod.service

import org.springframework.web.multipart.MultipartFile


/**
 * @author coderpwh
 * @date 2022/5/7 4:37 PM
 */
interface VideoService {
    fun uploadVideo(file:MultipartFile):String
    fun deleteVideo(videoId:String):Unit
}