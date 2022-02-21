package com.coderpwh.eduservice.controller;


import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.service.IEduSubjectService
import org.springframework.web.bind.annotation.*

import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-18
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
class EduSubjectController {
    @Resource
    lateinit var subjectService: IEduSubjectService

    /**
     * 添加课程分类
     */
    @PostMapping("addSubject")
    fun addSubject(file: MultipartFile):R {
        subjectService.saveSubject(file)
        return R.ok()
    }

    @GetMapping("allSubject")
    fun getAllSubject():R {
        var subjectList = subjectService.subjectList()
        return R.ok().data("list",subjectList)
    }

}
