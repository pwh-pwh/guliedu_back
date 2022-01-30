package com.coderpwh.eduservice.handler

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.util.*
@Component
class MyMetaObjectHandler :MetaObjectHandler{
    override fun insertFill(metaObject: MetaObject?) {
        fillStrategy(metaObject, "gmtCreate", Date())
        fillStrategy(metaObject, "gmtModified", Date())
        fillStrategy(metaObject, "isDeleted", 0)
    }

    override fun updateFill(metaObject: MetaObject?) {
        fillStrategy(metaObject, "gmtModified", Date())
    }
}