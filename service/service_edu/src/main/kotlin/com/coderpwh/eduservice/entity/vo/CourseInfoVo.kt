package com.coderpwh.eduservice.entity.vo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

@ApiModel(value = "课程基本信息", description = "课程基本信息vo")
class CourseInfoVo:Serializable {
    @ApiModelProperty(value = "课程ID")
    var id: String? = null

    @ApiModelProperty(value = "课程讲师ID")
    var teacherId: String? = null

    @ApiModelProperty(value = "课程专业ID")
    var subjectId: String? = null

    @ApiModelProperty(value = "课程专业父级ID")
    var subjectParentId: String? = null

    @ApiModelProperty(value = "课程标题")
    var title: String? = null

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看")
    var price: BigDecimal? = null

    @ApiModelProperty(value = "总课时")
    var lessonNum: Int? = null

    @ApiModelProperty(value = "课程封面图片路径")
    var cover: String? = null

    @ApiModelProperty(value = "课程简介")
    var description: String?=null
}