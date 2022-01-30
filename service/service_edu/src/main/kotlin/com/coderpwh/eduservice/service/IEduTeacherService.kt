package com.coderpwh.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.eduservice.query.TeacherQuery

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2022-01-30
 */
interface IEduTeacherService : IService<EduTeacher> {
    fun pageQuery(pageParam: Page<EduTeacher>,teacherQuery: TeacherQuery?)
    fun pageQuery(pageParam: Page<EduTeacher>)
}
