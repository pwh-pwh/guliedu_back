package com.coderpwh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 课程简介
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@TableName("edu_course_description")
@ApiModel(value = "EduCourseDescription对象", description = "课程简介")
class EduCourseDescription : Serializable {

    @ApiModelProperty(value = "课程ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: String? = null

    @ApiModelProperty(value = "课程简介")
    var description: String? = null

    @ApiModelProperty(value = "创建时间")
    var gmtCreate: Date? = null

    @ApiModelProperty(value = "更新时间")
    var gmtModified: Date? = null

    override fun toString(): String {
        return "EduCourseDescription{" +
        "id=" + id +
        ", description=" + description +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
