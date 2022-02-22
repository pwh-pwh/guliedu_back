package com.coderpwh.eduservice.service;

import com.coderpwh.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.eduservice.entity.vo.CourseInfoVo

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
interface IEduCourseService : IService<EduCourse> {
    /**
     * 保存课程信息并返回id
     */
    fun saveCourseInfo(courseInfoVo: CourseInfoVo):String
}
