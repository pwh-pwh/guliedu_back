package com.coderpwh.vod.controller

import com.coderpwh.commonutils.R
import com.coderpwh.vod.service.VideoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource


/**
 * @author coderpwh
 * @date 2022/5/7 4:59 PM
 */
@Controller
@CrossOrigin
@RestController
@RequestMapping("/admin/vod/video")
class VideoController {
    @Resource
    lateinit var videoService: VideoService
    @PostMapping("upload")
    fun upLoadVideo(
        @RequestParam("file")
        file: MultipartFile
    ): R {
        var videoId = videoService.uploadVideo(file)
        return R.ok().msg("success upload").data("videoId", videoId)
    }
    @DeleteMapping("{videoId}")
    fun deleteVideo(
        @PathVariable("videoId")
        videoId:String
    ):R {
        videoService.deleteVideo(videoId)
        return R.ok().msg("success delete")
    }
    @GetMapping("hi")
    fun sayHi(@RequestParam
    name:String
    ):R {
        return R.ok().msg("hi ${name}")
    }

}