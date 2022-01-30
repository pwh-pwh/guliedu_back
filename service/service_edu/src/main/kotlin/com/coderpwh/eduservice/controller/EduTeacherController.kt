package com.coderpwh.eduservice.controller;


import com.coderpwh.eduservice.entity.EduTeacher
import com.coderpwh.eduservice.service.IEduTeacherService
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
class EduTeacherController{
    @Resource
    lateinit var eduTeacherService:IEduTeacherService

    @RequestMapping("/list")
    fun list(): MutableList<EduTeacher>? {
        return eduTeacherService.list()
    }

    @DeleteMapping("/delete/{id}")
    fun delete(
        @ApiParam(value = "讲师id", name = "id", required = true)
        @PathVariable("id") id:String):Boolean {
        return eduTeacherService.removeById(id)
    }

}





