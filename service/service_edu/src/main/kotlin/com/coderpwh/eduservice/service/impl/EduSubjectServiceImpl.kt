package com.coderpwh.eduservice.service.impl;

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.read.listener.PageReadListener
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.coderpwh.eduservice.entity.EduSubject;
import com.coderpwh.eduservice.mapper.EduSubjectMapper;
import com.coderpwh.eduservice.service.IEduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.eduservice.entity.SubjectData
import com.coderpwh.eduservice.entity.subject.OneSubject
import com.coderpwh.eduservice.entity.subject.TwoSubject
import com.coderpwh.eduservice.listener.SubjectExcelListener
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils
import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource
import javax.security.auth.Subject

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-18
 */
@Service
open class EduSubjectServiceImpl : ServiceImpl<EduSubjectMapper, EduSubject>(), IEduSubjectService {
    @Resource
    lateinit var subjectMapper: EduSubjectMapper
    override fun saveSubject(file: MultipartFile) {
        EasyExcel.read(file.inputStream,SubjectData::class.java,SubjectExcelListener(this))
            .sheet()
            .doRead()
    }

    override fun subjectList(): List<OneSubject> {
        var wrapper = QueryWrapper<EduSubject>()
        wrapper.eq("parent_id","0")
        var parentList = subjectMapper.selectList(wrapper)
        var oneSubjects = mutableListOf<OneSubject>()
        parentList.forEach {
            var wp = QueryWrapper<EduSubject>()
            wp.eq("parent_id",it.id)
            var sonList = subjectMapper.selectList(wp)
            var twoSubject = mutableListOf<TwoSubject>()
            sonList.forEach {
                item ->
                twoSubject.add(TwoSubject().apply {
                    BeanUtils.copyProperties(item,this)
                    println(this.id)
                    println(this.title)
                })
            }
            oneSubjects.add(OneSubject().apply {
                BeanUtils.copyProperties(it,this)

                this.children = twoSubject as List<TwoSubject>?
                /*this.title = it.title
                this.id = it.id*/
            })
        }
        return oneSubjects
    }


}
