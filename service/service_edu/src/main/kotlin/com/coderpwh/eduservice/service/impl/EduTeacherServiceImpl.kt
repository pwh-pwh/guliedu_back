package com.coderpwh.eduservice.service.impl;

import com.coderpwh.eduservice.entity.EduTeacher;
import com.coderpwh.eduservice.mapper.EduTeacherMapper;
import com.coderpwh.eduservice.service.IEduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-01-30
 */
@Service
open class EduTeacherServiceImpl : ServiceImpl<EduTeacherMapper, EduTeacher>(), IEduTeacherService {

}
