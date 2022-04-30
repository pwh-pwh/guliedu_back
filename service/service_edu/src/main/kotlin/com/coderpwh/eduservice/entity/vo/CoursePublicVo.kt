package com.coderpwh.eduservice.entity.vo

import java.math.BigDecimal


/**
 * @author coderpwh
 * @date 2022/4/30 10:12 AM
 */
class CoursePublicVo:java.io.Serializable {
    var title: String?=null
    var cover: String?=null
    var lessonNum: Int? = null
    var subject: String? = null
    var subjectParent: String? = null
    var teacherName: String? = null
    var price: BigDecimal? = null

}