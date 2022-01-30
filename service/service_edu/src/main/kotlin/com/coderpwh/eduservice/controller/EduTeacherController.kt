package com.coderpwh.eduservice.controller;


import com.coderpwh.eduservice.entity.EduTeacher
import com.coderpwh.eduservice.service.IEduTeacherService
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
class EduTeacherController{
    @Resource
    lateinit var eduTeacherService:IEduTeacherService

    @RequestMapping("/list")
    fun list(): MutableList<EduTeacher>? {
        return eduTeacherService.list()
    }

}





