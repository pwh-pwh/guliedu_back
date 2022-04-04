package com.coderpwh.eduservice.entity.vo

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

class VideoVo : Serializable {
    var id: String? = null
    var title: String? = null
    var free: Int? = null

}