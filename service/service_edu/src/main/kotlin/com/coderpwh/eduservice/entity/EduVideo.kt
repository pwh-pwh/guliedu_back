package com.coderpwh.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@TableName("edu_video")
@ApiModel(value = "EduVideo对象", description = "课程视频")
class EduVideo : Serializable {

    @ApiModelProperty(value = "视频ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: String? = null

    @ApiModelProperty(value = "课程ID")
    var courseId: String? = null

    @ApiModelProperty(value = "章节ID")
    var chapterId: String? = null

    @ApiModelProperty(value = "节点名称")
    var title: String? = null

    @ApiModelProperty(value = "云端视频资源")
    var videoSourceId: String? = null

    @ApiModelProperty(value = "原始文件名称")
    var videoOriginalName: String? = null

    @ApiModelProperty(value = "排序字段")
    var sort: Int? = null

    @ApiModelProperty(value = "播放次数")
    var playCount: Long? = null

    @ApiModelProperty(value = "是否可以试听：0收费 1免费")
    @TableField("is_free")
    var free: Boolean? = null

    @ApiModelProperty(value = "视频时长（秒）")
    var duration: Float? = null

    @ApiModelProperty(value = "Empty未上传 Transcoding转码中  Normal正常")
    var status: String? = null

    @ApiModelProperty(value = "视频源文件大小（字节）")
    var size: Long? = null

    @ApiModelProperty(value = "乐观锁")
    var version: Long? = null

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    var gmtCreate: Date? = null

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    var gmtModified: Date? = null

    override fun toString(): String {
        return "EduVideo{" +
        "id=" + id +
        ", courseId=" + courseId +
        ", chapterId=" + chapterId +
        ", title=" + title +
        ", videoSourceId=" + videoSourceId +
        ", videoOriginalName=" + videoOriginalName +
        ", sort=" + sort +
        ", playCount=" + playCount +
        ", isFree=" + free +
        ", duration=" + duration +
        ", status=" + status +
        ", size=" + size +
        ", version=" + version +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}"
    }
}
