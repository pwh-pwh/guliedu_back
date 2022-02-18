package com.coderpwh

import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.read.listener.ReadListener
import com.alibaba.excel.util.ListUtils
import com.alibaba.fastjson.JSON
import com.coderpwh.pojo.DemoData
import springfox.documentation.spring.web.json.Json

class DemoDataListener:ReadListener<DemoData> {
    companion object {
        val BATCH_COUNT = 100
    }

    var cachedDataList: MutableList<DemoData> = ListUtils.newArrayListWithCapacity(BATCH_COUNT)
    override fun invoke(p0: DemoData, p1: AnalysisContext) {
        println("解析到一条数据:${JSON.toJSONString(p0)}")
        cachedDataList.add(p0)
        if (cachedDataList.size>= BATCH_COUNT) {
            saveData()
            cachedDataList = ListUtils.newArrayListWithCapacity(BATCH_COUNT)
        }
    }

    fun saveData() {
        println("保存到数据库")
    }
    override fun doAfterAllAnalysed(p0: AnalysisContext?) {
        saveData()
        println("数据解析完成")
    }
}