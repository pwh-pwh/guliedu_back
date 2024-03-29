package com.coderpwh.eduservice.service.impl;

import com.coderpwh.eduservice.entity.EduCourseDescription;
import com.coderpwh.eduservice.mapper.EduCourseDescriptionMapper;
import com.coderpwh.eduservice.service.IEduCourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@Service
open class EduCourseDescriptionServiceImpl : ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription>(), IEduCourseDescriptionService {

}
