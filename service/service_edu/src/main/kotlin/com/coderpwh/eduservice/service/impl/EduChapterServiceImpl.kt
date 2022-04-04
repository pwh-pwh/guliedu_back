package com.coderpwh.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.coderpwh.eduservice.entity.EduChapter;
import com.coderpwh.eduservice.mapper.EduChapterMapper;
import com.coderpwh.eduservice.service.IEduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.commonutils.ResultCode
import com.coderpwh.eduservice.entity.EduVideo
import com.coderpwh.eduservice.entity.vo.ChapterVo
import com.coderpwh.eduservice.entity.vo.VideoVo
import com.coderpwh.eduservice.service.IEduVideoService
import com.coderpwh.servicebase.exception.GuliException
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service;
import javax.annotation.Resource

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
    @Resource
    lateinit var videoService: IEduVideoService

    override fun nestedList(courseId:String): List<ChapterVo> {
        var wrapper = QueryWrapper<EduChapter>()
        wrapper.eq("course_id",courseId)
        wrapper.orderByAsc("sort","id")
        var list = this.list(wrapper)
        var chapterVos = mutableListOf<ChapterVo>()
        list.forEach {
            var videoWrapper = QueryWrapper<EduVideo>()
            videoWrapper.eq("chapter_id",it.id)
            var videos = videoService.list(videoWrapper)
            var videoVos = mutableListOf<VideoVo>()
            videos.forEach {

                videoVos.add(VideoVo().apply {
                    BeanUtils.copyProperties(it,this)
                    println(this)
                })
            }
            var chapterVo = ChapterVo()
            BeanUtils.copyProperties(it,chapterVo)
            chapterVo.videos = videoVos
            chapterVos.add(chapterVo)
        }
        return chapterVos
    }

    override fun deleteChapter(chapterId: String):Boolean {
        var videoVoQueryWrapper = QueryWrapper<EduVideo>()
        videoVoQueryWrapper.eq("chapter_id",chapterId)
        var count = videoService.count(videoVoQueryWrapper)
        if (count>0) {
            throw GuliException(ResultCode.ERROR,"不能删除")
        }
        return removeById(chapterId)
    }

}
