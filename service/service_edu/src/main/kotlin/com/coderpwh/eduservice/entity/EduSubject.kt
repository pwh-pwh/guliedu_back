package com.coderpwh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-18
 */
@TableName("edu_subject")
@ApiModel(value = "EduSubject对象", description = "课程科目")
class EduSubject : Serializable {

    @ApiModelProperty(value = "课程类别ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: String? = null

    @ApiModelProperty(value = "类别名称")
    var title: String? = null

    @ApiModelProperty(value = "父ID")
    var parentId: String? = null

    @ApiModelProperty(value = "排序字段")
    var sort: Int? = null

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    var gmtCreate: Date? = null

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var gmtModified: Date? = null

    override fun toString(): String {
        return "EduSubject{" +
        "id=" + id +
        ", title=" + title +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
