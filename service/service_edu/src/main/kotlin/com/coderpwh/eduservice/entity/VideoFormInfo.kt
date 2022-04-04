package com.coderpwh.eduservice.entity


/**
 * @author pwh
 * @date 2022/4/4 下午8:19
 */
data class VideoFormInfo(
    var id:String?=null,
    var courseId:String?=null,
    var chapterId:String?=null,
    var title:String?=null,
    var videoSourceId:String?=null,
    var sort:Int?=null,
    var free:Boolean?=null
)
