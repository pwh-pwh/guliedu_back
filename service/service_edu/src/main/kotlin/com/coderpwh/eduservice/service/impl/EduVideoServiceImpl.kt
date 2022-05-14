package com.coderpwh.eduservice.service.impl;

import com.alibaba.nacos.common.utils.StringUtils
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.coderpwh.eduservice.entity.EduVideo;
import com.coderpwh.eduservice.mapper.EduVideoMapper;
import com.coderpwh.eduservice.service.IEduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.client.VosClient
import org.springframework.beans.factory.annotation.Autowired
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
    @Autowired
    lateinit var vosClient: VosClient
    override fun removeByCourseId(courseId: String): Boolean {
        var queryWrapper = QueryWrapper<EduVideo>()
        queryWrapper.eq("course_id",courseId)
        return baseMapper.delete(queryWrapper)>0
    }

    override fun removeVideoById(id: String): Boolean {
        var videoSourceId = baseMapper.selectById(id).videoSourceId
        if (StringUtils.isNotEmpty(videoSourceId)) {
            vosClient.deleteVideo(videoSourceId!!)
        }
        return baseMapper.deleteById(id)>0
    }

    override fun getSayHi(name: String) = vosClient.sayHi(name).message!!
}
