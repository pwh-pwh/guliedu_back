package com.coderpwh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author coderpwh
 * @since 2022-01-30
 */
@TableName("edu_teacher")
@ApiModel(value = "EduTeacher对象", description = "讲师")
class EduTeacher : Serializable {

    @ApiModelProperty(value = "讲师ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: String? = null

    @ApiModelProperty(value = "讲师姓名")
    var name: String? = null

    @ApiModelProperty(value = "讲师简介")
    var intro: String? = null

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    var career: String? = null

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    var level: Int? = null

    @ApiModelProperty(value = "讲师头像")
    var avatar: String? = null

    @ApiModelProperty(value = "排序")
    var sort: Int? = null

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    var isDeleted: Int? = null

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    var gmtCreate: Date? = null

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    var gmtModified: Date? = null

    override fun toString(): String {
        return "EduTeacher{" +
        "id=" + id +
        ", name=" + name +
        ", intro=" + intro +
        ", career=" + career +
        ", level=" + level +
        ", avatar=" + avatar +
        ", sort=" + sort +
        ", isDeleted=" + isDeleted +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
