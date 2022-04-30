package com.coderpwh.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.eduservice.entity.EduCourse;
import com.coderpwh.eduservice.mapper.EduCourseMapper;
import com.coderpwh.eduservice.service.IEduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.commonutils.ResultCode
import com.coderpwh.eduservice.entity.EduCourseDescription
import com.coderpwh.eduservice.entity.dto.CourseQuery
import com.coderpwh.eduservice.entity.vo.CourseInfoVo
import com.coderpwh.eduservice.entity.vo.CoursePublicVo
import com.coderpwh.eduservice.service.IEduChapterService
import com.coderpwh.eduservice.service.IEduCourseDescriptionService
import com.coderpwh.eduservice.service.IEduSubjectService
import com.coderpwh.servicebase.exception.GuliException
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@Service
@Transactional
open class EduCourseServiceImpl : ServiceImpl<EduCourseMapper, EduCourse>(), IEduCourseService {
    @Autowired
    lateinit var ecds: IEduCourseDescriptionService
    @Autowired
    lateinit var subjectService: IEduSubjectService
    @Autowired
    lateinit var videoService: IEduSubjectService
    @Autowired
    lateinit var chapterService: IEduChapterService

    override fun saveCourseInfo(courseInfoVo: CourseInfoVo): String {
        var eduCourse = EduCourse()
        BeanUtils.copyProperties(courseInfoVo,eduCourse)
        var flag4Course = this.save(eduCourse)
        if (!flag4Course) {
            throw GuliException(ResultCode.ERROR,"保存课程信息失败")
        }
        var cDescription = EduCourseDescription()
        cDescription.id = eduCourse.id
        cDescription.description = courseInfoVo.description
        var flag4D = ecds.save(cDescription)
        if (!flag4D){
            throw GuliException(ResultCode.ERROR,"保存课程描述信息失败")
        }
        return eduCourse.id!!
    }

    override fun pageQuery4Course(page: Page<EduCourse>, courseQuery: CourseQuery) {
        var queryWrapper = QueryWrapper<EduCourse>()
        queryWrapper.orderByDesc("gmt_create")
        if (StringUtils.isNotEmpty(courseQuery.title)) {
            queryWrapper.like("title",courseQuery.title)
        }
        if (StringUtils.isNotEmpty(courseQuery.teacherId)) {
            queryWrapper.eq("teacher_id",courseQuery.teacherId)
        }

        if (StringUtils.isNotEmpty(courseQuery.subjectId)) {
            queryWrapper.eq("subject_id",courseQuery.subjectId)
        }
        if (StringUtils.isNotEmpty(courseQuery.subjectParentId)) {
            queryWrapper.eq("subject_parent_id",courseQuery.subjectParentId)
        }
        baseMapper.selectPage(page,queryWrapper)

    }

    override fun removeCourse(courseId: String): Boolean {
        chapterService.deleteByCourseId(courseId)
        subjectService.removeByCourseId(courseId)
        videoService.removeByCourseId(courseId)
        return baseMapper.deleteById(courseId)>0
    }

    override fun getCourseDetailInfo(courseId: String): CourseInfoVo {
        //查询课程信息
        var course = getById(courseId)
        //查询评价信息
        var description = ecds.getById(courseId)
        val courseInfoVo = CourseInfoVo()
        BeanUtils.copyProperties(course,courseInfoVo)
        BeanUtils.copyProperties(description,courseInfoVo)
        return courseInfoVo
    }

    override fun updateCourseInfo(courseInfoVo: CourseInfoVo): Boolean {
        var course = EduCourse()
        BeanUtils.copyProperties(courseInfoVo,course)
        var flag = updateById(course)
        if (!flag) {
            return flag
        }
        ecds.updateById(EduCourseDescription().apply {
            BeanUtils.copyProperties(courseInfoVo,this)
        })
        return true;
    }

    override fun getCoursePublic(courseId: String): CoursePublicVo {
        return this.baseMapper.getPublicCourseInfo(courseId)
    }

}
