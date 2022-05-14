package com.coderpwh.eduservice.client

import com.coderpwh.commonutils.R
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam


/**
 * @author coderpwh
 * @date 2022/5/14 9:44 AM
 */
@FeignClient("service-vod")
@Component
interface VosClient {
    @DeleteMapping("/admin/vod/video/{videoId}")
    fun deleteVideo(
        @PathVariable("videoId")
        videoId:String
    ): R

    @GetMapping("/admin/vod/video/hi")
    fun sayHi(@RequestParam
              name:String
    ):R
}