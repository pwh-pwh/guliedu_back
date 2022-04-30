package com.coderpwh.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.eduservice.entity.dto.CourseQuery
import com.coderpwh.eduservice.entity.vo.CourseInfoVo
import com.coderpwh.eduservice.entity.vo.CoursePublicVo

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
    fun getCourseDetailInfo(courseId:String):CourseInfoVo
    fun updateCourseInfo(courseInfoVo: CourseInfoVo):Boolean

    fun getCoursePublic(courseId:String):CoursePublicVo

    fun pageQuery4Course(page: Page<EduCourse>,courseQuery: CourseQuery):Unit

    fun removeCourse(courseId:String):Boolean
}
