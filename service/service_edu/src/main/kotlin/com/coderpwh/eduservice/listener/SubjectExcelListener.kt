package com.coderpwh.eduservice.listener

import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.event.AnalysisEventListener
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.coderpwh.commonutils.ResultCode
import com.coderpwh.eduservice.entity.EduSubject
import com.coderpwh.eduservice.entity.SubjectData
import com.coderpwh.eduservice.service.IEduSubjectService
import com.coderpwh.servicebase.exception.GuliException

class SubjectExcelListener: AnalysisEventListener<SubjectData> {
    val subjectService: IEduSubjectService
    constructor(subjectService: IEduSubjectService) : super() {
        this.subjectService = subjectService
    }
    override fun invoke(p0: SubjectData?, p1: AnalysisContext?) {
        if(p0 == null) {
            throw GuliException(ResultCode.ERROR,"文件数据为空")
        }
        var existOneSubject = existOneSubject(p0.oneSubjectName!!)
        if (existOneSubject == null) {
            existOneSubject = EduSubject()
            existOneSubject.title = p0.oneSubjectName
            existOneSubject.parentId = "0"
            subjectService.save(existOneSubject)
        }
        var pid = existOneSubject.id
        var existTwoSubject = existTwoSubject(p0.twoSubjectName!!, pid!!)
        if (existTwoSubject == null) {
            existTwoSubject = EduSubject()
            existTwoSubject.title = p0.twoSubjectName
            existTwoSubject.parentId = pid
            println(existTwoSubject)
            subjectService.save(existTwoSubject)
        }

    }

    override fun doAfterAllAnalysed(p0: AnalysisContext?) {

    }

    /**
     * 判断一级分类不能重复添加
     */
    fun existOneSubject(name: String):EduSubject? {
        val wrapper = QueryWrapper<EduSubject>()
        wrapper.eq("title",name)
        wrapper.eq("parent_id","0")
        var eduSubject = subjectService.getOne(wrapper)
        return eduSubject
    }

    /**
     * 判断二级分类不能重复添加
     */
    fun existTwoSubject(name:String,pid: String):EduSubject? {
        val wrapper = QueryWrapper<EduSubject>()
        wrapper.eq("title",name)
        wrapper.eq("parent_id",pid)
        var eduSubject = subjectService.getOne(wrapper)
        return eduSubject
    }

}