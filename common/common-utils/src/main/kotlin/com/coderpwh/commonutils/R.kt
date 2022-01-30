package com.coderpwh.commonutils

import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

class R :Serializable{
    @ApiModelProperty(value = "是否成功")
    var success:Boolean? = true
    @ApiModelProperty(value = "返回码")
    var code:Int? = null
    @ApiModelProperty(value = "消息")
    var message:String? = null
    @ApiModelProperty(value = "返回数据")
    var data:HashMap<String,Any> = HashMap()
    private constructor()

    fun data(key:String,value:Any):R{
        data[key] = value
        return this
    }
    fun data(map:Map<String,Any>):R {
        data = map as HashMap<String, Any>
        return this
    }
    fun msg(msg:String?):R {
        this.message = msg
        return this
    }
    fun code(code:Int?):R {
        this.code = code
        return this
    }

    companion object {
        fun ok():R{
            var r = R()
            r.success = true
            r.code = ResultCode.SUCCESS
            r.message = "success"
            return r
        }
        fun error():R{
            var r = R()
            r.success = false
            r.code = ResultCode.ERROR
            r.message = "error"
            return r
        }

    }

}