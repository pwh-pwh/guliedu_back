package com.coderpwh.eduservice.service.impl;

import com.coderpwh.eduservice.entity.EduCourse;
import com.coderpwh.eduservice.mapper.EduCourseMapper;
import com.coderpwh.eduservice.service.IEduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.commonutils.ResultCode
import com.coderpwh.eduservice.entity.EduCourseDescription
import com.coderpwh.eduservice.entity.vo.CourseInfoVo
import com.coderpwh.eduservice.service.IEduCourseDescriptionService
import com.coderpwh.servicebase.exception.GuliException
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
    override fun saveCourseInfo(courseInfoVo: CourseInfoVo): String {
        var eduCourse = EduCourse()
        BeanUtils.copyProperties(courseInfoVo,eduCourse)
        eduCourse.subjectParentId = eduCourse.subjectId
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

}
