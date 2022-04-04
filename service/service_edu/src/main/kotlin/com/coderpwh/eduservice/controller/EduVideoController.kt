package com.coderpwh.eduservice.controller;


import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.entity.EduVideo
import com.coderpwh.eduservice.entity.VideoFormInfo
import com.coderpwh.eduservice.service.IEduVideoService
import org.apache.ibatis.annotations.Delete
import org.springframework.beans.BeanUtils
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/eduservice/edu-video")
@CrossOrigin
class EduVideoController {
    @Resource
    lateinit var videoService: IEduVideoService

    @PostMapping
    fun addVideo(
        @RequestBody
        videoFormInfo: VideoFormInfo
    ):R {
        println(videoFormInfo)
        var eduVideo = EduVideo()
        BeanUtils.copyProperties(videoFormInfo,eduVideo)
        videoService.save(eduVideo)
        return R.ok()
    }

    @PutMapping
    fun updateVideo(
        @RequestBody
        videoFormInfo: VideoFormInfo
    ):R {
        var eduVideo = EduVideo()
        BeanUtils.copyProperties(videoFormInfo,eduVideo)
        videoService.updateById(eduVideo)
        return R.ok()
    }

    @DeleteMapping("{id}")
    fun deleteVideo(
        @PathVariable("id")
        id:String
    ):R {
        videoService.removeById(id)
        return R.ok()
    }

    @GetMapping("{id}")
    fun getVideoById(
        @PathVariable("id")
        id:String
    ):R {
        var video = videoService.getById(id)
        var videoFormInfo = VideoFormInfo()
        BeanUtils.copyProperties(video,videoFormInfo)
        return R.ok().data("video",videoFormInfo)
    }


}
