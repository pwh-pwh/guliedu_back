package com.coderpwh

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.read.listener.PageReadListener
import com.alibaba.fastjson.JSON
import com.coderpwh.pojo.DemoData
import org.junit.Test
import java.util.*

class ExcelTest {
    fun data(): List<DemoData> {
        var list = mutableListOf<DemoData>()
        for (i in 0..9) {
            var demoData = DemoData("字符串" + i, Date(), 0.56)
            list.add(demoData)
        }
        println(list.toString())
        return list
    }

    @Test
    fun simpleWrite() {
        var fileName: String = "simpleWrite" + System.currentTimeMillis() + ".xlsx"
        EasyExcel.write(fileName,DemoData::class.java)
            .sheet("模板1")
            .doWrite {
                data()
            }

    }
    @Test
    fun simpleRead() {
        var fileName = "test" + ".xlsx"
        EasyExcel.read(fileName,DemoData::class.java,PageReadListener<DemoData>(){
            println(it)
        }).sheet().doRead()
    }



}