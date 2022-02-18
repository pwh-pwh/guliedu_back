package com.coderpwh.eduservice.entity

import com.alibaba.excel.annotation.ExcelProperty

data class SubjectData(
    @ExcelProperty(index = 0)
    var oneSubjectName: String?,
    @ExcelProperty(index = 1)
    var twoSubjectName: String?
    ){
    constructor():this(oneSubjectName = null,twoSubjectName = null){}
}
