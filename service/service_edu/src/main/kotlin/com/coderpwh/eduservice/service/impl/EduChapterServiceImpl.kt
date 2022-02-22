package com.coderpwh.eduservice.service.impl;

import com.coderpwh.eduservice.entity.EduChapter;
import com.coderpwh.eduservice.mapper.EduChapterMapper;
import com.coderpwh.eduservice.service.IEduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@Service
open class EduChapterServiceImpl : ServiceImpl<EduChapterMapper, EduChapter>(), IEduChapterService {

}
