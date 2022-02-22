package com.coderpwh.eduservice.controller;


import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.entity.vo.CourseInfoVo
import com.coderpwh.eduservice.service.IEduCourseService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
class EduCourseController{
    @Resource
    lateinit var courseService:IEduCourseService

    @ApiOperation("新增课程信息")
    @PostMapping("save")
    fun saveCourseInfo(
        @RequestBody
        @ApiParam(value = "课程信息", name = "courseInfoVo", required = true)
        courseInfoVo: CourseInfoVo
    ):R {
        var id = courseService.saveCourseInfo(courseInfoVo)
        if (!StringUtils.isEmpty(id)) {
            return R.ok().data("course_Id",id)
        }
        return R.error().msg("未知错误")
    }
}
