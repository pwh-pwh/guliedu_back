package com.coderpwh.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.entity.EduTeacher
import com.coderpwh.eduservice.query.TeacherQuery
import com.coderpwh.eduservice.service.IEduTeacherService
import com.coderpwh.servicebase.exception.GuliException
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-01-30
 */
@CrossOrigin
@RestController
@RequestMapping("/eduservice/edu-teacher")
class EduTeacherController {
    @Resource
    lateinit var eduTeacherService: IEduTeacherService


    @DeleteMapping("/{id}")
    fun delete(
        @ApiParam(value = "讲师id", name = "id", required = true)
        @PathVariable("id") id: String
    ): R {
        eduTeacherService.removeById(id)
        return R.ok()
    }

    @GetMapping("/list")
    fun getList():R {
        var list = eduTeacherService.list()
        print(list.size)
        return R.ok().data("list",list)
    }

    @PostMapping("/{current}/{limit}")
    fun pageList(
        @PathVariable("current")
        @ApiParam(name = "current", value = "当前页码", required = true)
        current: Long,
        @PathVariable("limit")
        @ApiParam(name = "limit", value = "每页记录数", required = true)
        limit: Long,
        @RequestBody
        @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
        teacherQuery: TeacherQuery
    ): R {
        var teacherPage = Page<EduTeacher>(current, limit)
        eduTeacherService.pageQuery(teacherPage, teacherQuery)
        var records = teacherPage.records
        var total = teacherPage.total
        return R.ok().data("total", total).data("rows", records)
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    fun save(
        @ApiParam(name = "teacher", value = "教师对象", required = true)
        @RequestBody
        teacher: EduTeacher
    ): R {
        eduTeacherService.save(teacher)
        return R.ok()
    }

    @ApiOperation(value = "根据id获取讲师")
    @GetMapping("/{id}")
    fun getById(
        @ApiParam(name = "id", value = "教师ID", required = true)
        @PathVariable("id")
        id: String
    ): R {
        var teacher = eduTeacherService.getById(id)
        return R.ok().data("item", teacher)
    }

    @ApiOperation("根据ID更新讲师")
    @PutMapping("{id}")
    fun updateById(
        @PathVariable("id")
        @ApiParam(name = "id", value = "教师ID", required = true)
        id: String,
        @RequestBody
        @ApiParam(name = "teacher", value = "教师对象", required = true)
        teacher: EduTeacher
    ): R {
        teacher.id = id
        eduTeacherService.updateById(teacher)
        return R.ok()
    }

    @RequestMapping("error")
    fun testError():String {
        try {
            1/0
        }catch (e:Exception) {
            throw GuliException(201,"自定义异常")
        }

        return "error"
    }


}





