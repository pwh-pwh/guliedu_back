package com.coderpwh.eduservice.service;

import com.coderpwh.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.eduservice.entity.vo.ChapterVo

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
interface IEduChapterService : IService<EduChapter> {
    fun nestedList(courseId:String):List<ChapterVo>
}
