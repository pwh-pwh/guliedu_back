package com.coderpwh.eduservice.controller;


import com.coderpwh.commonutils.R
import com.coderpwh.eduservice.entity.EduChapter
import com.coderpwh.eduservice.service.IEduChapterService
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*

import javax.annotation.Resource

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
class EduChapterController {
    @Resource
    lateinit var chapterService: IEduChapterService

    @GetMapping("nested-list/{courseId}")
    fun nestedListByCourseId(
        @PathVariable("courseId")
        courseId:String):R {
        if (StringUtils.isEmpty(courseId)) {
            return R.error().msg("参数不合法")
        }
        var list = chapterService.nestedList(courseId)
        return R.ok().data("list",list)
    }

    //添加章节
    @PostMapping("addChapter")
    fun addChapter(
        @RequestBody
        chapter: EduChapter
    ):R {
        chapterService.save(chapter)
        return R.ok()
    }

    //修改章节
    @PostMapping("updateChapter")
    fun updateChapter(
        @RequestBody
        chapter: EduChapter
    ):R {
        chapterService.updateById(chapter)
        return R.ok()
    }

    //删除章节
    @DeleteMapping("deleteChapter/{chapterId}")
    fun deleteChapter(
        @PathVariable("chapterId")
        chapterId:String
    ):R {
        chapterService.removeById(chapterId)
        return R.ok()
    }

}
