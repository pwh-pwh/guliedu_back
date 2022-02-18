package com.coderpwh.pojo

import com.alibaba.excel.annotation.ExcelProperty
import java.util.*

data class DemoData(@ExcelProperty("字符串标题") var string: String?, @ExcelProperty("日期标题") var date: Date?, @ExcelProperty("数字标题") var doubleData: Double?) {
    constructor() : this(string = null, date = null, doubleData = null) {}
}