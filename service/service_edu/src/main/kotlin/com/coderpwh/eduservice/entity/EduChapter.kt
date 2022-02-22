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
 * 课程
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@TableName("edu_chapter")
@ApiModel(value = "EduChapter对象", description = "课程")
class EduChapter : Serializable {

    @ApiModelProperty(value = "章节ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: String? = null

    @ApiModelProperty(value = "课程ID")
    var courseId: String? = null

    @ApiModelProperty(value = "章节名称")
    var title: String? = null

    @ApiModelProperty(value = "显示排序")
    var sort: Int? = null

    @ApiModelProperty(value = "创建时间")
    var gmtCreate: Date? = null

    @ApiModelProperty(value = "更新时间")
    var gmtModified: Date? = null

    override fun toString(): String {
        return "EduChapter{" +
        "id=" + id +
        ", courseId=" + courseId +
        ", title=" + title +
        ", sort=" + sort +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
