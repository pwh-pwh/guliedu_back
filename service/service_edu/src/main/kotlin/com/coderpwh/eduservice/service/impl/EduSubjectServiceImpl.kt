package com.coderpwh.eduservice.service.impl;

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.read.listener.PageReadListener
import com.coderpwh.eduservice.entity.EduSubject;
import com.coderpwh.eduservice.mapper.EduSubjectMapper;
import com.coderpwh.eduservice.service.IEduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.eduservice.entity.SubjectData
import com.coderpwh.eduservice.listener.SubjectExcelListener
import org.springframework.stereotype.Service;
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


}
