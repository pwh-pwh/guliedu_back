package com.coderpwh.eduservice.service;

import com.coderpwh.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
interface IEduVideoService : IService<EduVideo> {
    fun removeByCourseId(courseId:String):Boolean
}
