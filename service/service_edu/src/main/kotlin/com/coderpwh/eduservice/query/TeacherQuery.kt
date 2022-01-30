package com.coderpwh.eduservice.query

import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

class TeacherQuery:Serializable {
    @ApiModelProperty(value = "教师名称模糊查询")
    var name:String?=null
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    val level:Int?=null
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    val begin:String?=null
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    val end:String?=null
}