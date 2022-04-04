package com.coderpwh.eduservice.entity.vo

import java.io.Serializable

class ChapterVo:Serializable {
    var id: String? = null
    var title: String? = null
    var videos: List<VideoVo>?=null
}