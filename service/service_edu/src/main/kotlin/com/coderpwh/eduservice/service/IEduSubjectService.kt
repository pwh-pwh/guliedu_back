package com.coderpwh.eduservice.service;

import com.coderpwh.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-18
 */
interface IEduSubjectService : IService<EduSubject> {
    fun saveSubject(file:MultipartFile)
}
