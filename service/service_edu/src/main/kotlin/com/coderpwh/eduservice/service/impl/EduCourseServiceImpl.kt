package com.coderpwh.eduservice.service.impl;

import com.coderpwh.eduservice.entity.EduCourse;
import com.coderpwh.eduservice.mapper.EduCourseMapper;
import com.coderpwh.eduservice.service.IEduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@Service
open class EduCourseServiceImpl : ServiceImpl<EduCourseMapper, EduCourse>(), IEduCourseService {

}
