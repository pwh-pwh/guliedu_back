package com.coderpwh.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.coderpwh.eduservice.entity.EduVideo;
import com.coderpwh.eduservice.mapper.EduVideoMapper;
import com.coderpwh.eduservice.service.IEduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@Service
open class EduVideoServiceImpl : ServiceImpl<EduVideoMapper, EduVideo>(), IEduVideoService {
    override fun removeByCourseId(courseId: String): Boolean {
        var queryWrapper = QueryWrapper<EduVideo>()
        queryWrapper.eq("course_id",courseId)
        return baseMapper.delete(queryWrapper)>0
    }

}
