package com.coderpwh.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.eduservice.entity.EduTeacher;
import com.coderpwh.eduservice.mapper.EduTeacherMapper;
import com.coderpwh.eduservice.service.IEduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.eduservice.query.TeacherQuery
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils

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
    override fun pageQuery(pageParam: Page<EduTeacher>, teacherQuery: TeacherQuery?) {
        var queryWrapper = QueryWrapper<EduTeacher>()
        queryWrapper.orderByAsc("sort")
        if (teacherQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper)
            return
        }
        if (!StringUtils.isEmpty(teacherQuery.name)) {
            queryWrapper.like("name", teacherQuery.name)
        }
        if (!StringUtils.isEmpty(teacherQuery.level)) {
            queryWrapper.eq("level", teacherQuery.level)
        }
        if (!StringUtils.isEmpty(teacherQuery.begin)) {
            queryWrapper.ge("gmt_create", teacherQuery.begin)
        }
        if (!StringUtils.isEmpty(teacherQuery.begin)) {
            queryWrapper.le("gmt_create", teacherQuery.begin)
        }
        baseMapper.selectPage(pageParam,queryWrapper)
    }
    override fun pageQuery(pageParam: Page<EduTeacher>) {
        pageQuery(pageParam,null)
    }
}
