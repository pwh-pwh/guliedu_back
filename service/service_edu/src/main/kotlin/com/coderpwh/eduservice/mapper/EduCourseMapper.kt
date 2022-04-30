package com.coderpwh.eduservice.mapper;

import com.coderpwh.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.eduservice.entity.vo.CoursePublicVo

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2022-02-22
 */
interface EduCourseMapper : BaseMapper<EduCourse> {
    fun getPublicCourseInfo(id:String):CoursePublicVo;
}
