package com.coderpwh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("edu_course")
@ApiModel(value = "EduCourse对象", description = "课程")
class EduCourse : Serializable {

    @ApiModelProperty(value = "课程ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "销售数量")
    var buyCount: Long? = null

    @ApiModelProperty(value = "浏览数量")
    var viewCount: Long? = null

    @ApiModelProperty(value = "乐观锁")
    var version: Long? = null

    @ApiModelProperty(value = "课程状态 Draft未发布  Normal已发布")
    var status: String? = null

    @TableField(fill=FieldFill.INSERT)
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
        return "EduCourse{" +
        "id=" + id +
        ", teacherId=" + teacherId +
        ", subjectId=" + subjectId +
        ", subjectParentId=" + subjectParentId +
        ", title=" + title +
        ", price=" + price +
        ", lessonNum=" + lessonNum +
        ", cover=" + cover +
        ", buyCount=" + buyCount +
        ", viewCount=" + viewCount +
        ", version=" + version +
        ", status=" + status +
        ", isDeleted=" + isDeleted +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
