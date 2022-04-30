package com.coderpwh

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.coderpwh.eduservice.EduServiceApplication
import com.coderpwh.eduservice.entity.EduCourse
import com.coderpwh.eduservice.entity.dto.CourseQuery
import com.coderpwh.eduservice.service.IEduCourseService
import com.coderpwh.eduservice.service.impl.EduCourseServiceImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


/**
 * @author coderpwh
 * @date 2022/4/30 4:49 PM
 */
@SpringBootTest(classes = [EduServiceApplication::class])
@RunWith(SpringRunner::class)
class KTTest {
    @Autowired
    lateinit var eduCourseService:IEduCourseService
    @Test
    fun testKt() {
        println("hello")
        println(eduCourseService)
        var page = Page.of<EduCourse>(0, 10)
        eduCourseService.pageQuery4Course(
            page,
            CourseQuery().apply {
                this.title = "t"
            }
        )

        page.records.forEach {
            it ->
            println(it)
        }
    }
}