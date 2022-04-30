package com.coderpwh.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.commonutils.R
import com.coderpwh.commonutils.ResultCode
import com.coderpwh.eduservice.entity.CourseStaticInfo
import com.coderpwh.eduservice.entity.EduCourse
import com.coderpwh.eduservice.entity.dto.CourseQuery
import com.coderpwh.eduservice.entity.vo.CourseInfoVo
import com.coderpwh.eduservice.service.IEduCourseService
import com.coderpwh.servicebase.exception.GuliException
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import java.util.Objects

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
class EduCourseController {
    @Resource
    lateinit var courseService: IEduCourseService

    @ApiOperation("新增课程信息")
    @PostMapping("save")
    fun saveCourseInfo(
        @RequestBody
        @ApiParam(value = "课程信息", name = "courseInfoVo", required = true)
        courseInfoVo: CourseInfoVo
    ): R {
        var id = courseService.saveCourseInfo(courseInfoVo)
        if (!StringUtils.isEmpty(id)) {
            return R.ok().data("course_Id", id)
        }
        return R.error().msg("未知错误")
    }

    @ApiOperation("修改课程信息")
    @PostMapping("update")
    fun updateCourseInfo(
        @RequestBody
        courseInfoVo: CourseInfoVo
    ): R {
        var flag = courseService.updateCourseInfo(courseInfoVo)
        if (!flag) {
            throw GuliException(ResultCode.ERROR, "更新失败")
        }
        return R.ok().msg("更新成功")
    }

    @ApiOperation("获取课程信息")
    @GetMapping("courseInfo/{courseId}")
    fun getCourseInfo(
        @ApiParam(value = "课程id", name = "courseId", required = true)
        @PathVariable("courseId")
        courseId: String
    ): R {
        if (StringUtils.isEmpty(courseId)) {
            return R.error().msg("参数不合法")
        }
        var course = courseService.getCourseDetailInfo(courseId)
        if (ObjectUtils.isEmpty(course)) {
            return R.error().msg("不存在该记录")
        }
        return R.ok().data("course", course)
    }

    @ApiOperation("根据课程id获取发布课程信息")
    @GetMapping("coursePublicInfo/{courseId}")
    fun getPublicCourseInfo(
        @ApiParam(value = "课程ID", name = "courseId", required = true)
        @PathVariable("courseId")
        courseId: String
    ): R {
        var coursePublicInfo = courseService.getCoursePublic(courseId)
        if (Objects.isNull(courseId)) {
            return R.error().msg("不存在改记录")
        }
        return R.ok().data("coursePublicInfo", coursePublicInfo)
    }

    @PutMapping("publicCourse/{courseId}")
    @ApiOperation(value = "课程最终发布")
    fun publicCourse(
        @ApiParam(value = "课程ID", name = "courseId", required = true)
        @PathVariable("courseId")
        courseId: String
    ): R {
        var course = EduCourse().apply {
            this.id = courseId
            this.status = CourseStaticInfo.PUBLIC
        }
        courseService.updateById(course)
        return R.ok()

    }

    @GetMapping("query/{page}/{limit}")
    fun pageQuery(
        @PathVariable("page")
        page: Long,
        @PathVariable("limit")
        limit: Long,
        courseQuery: CourseQuery
    ):R {
        var page: Page<EduCourse> = Page.of(page,limit)
        courseService.pageQuery4Course(page,courseQuery)
        return R.ok().data("total",page.total).data("rows",page.records)
    }

    @DeleteMapping("{courseId}")
    fun deleteCourse(
        @PathVariable("courseId")
        courseId: String
    ):R {
        var flag = courseService.removeCourse(courseId)
        if(!flag) {
            return R.error()
        }
        return R.ok()
    }

}
