package com.coderpwh.servicebase.exception

import io.swagger.annotations.ApiModelProperty

class GuliException : RuntimeException {
    @ApiModelProperty(value = "状态码")
    var code:Int?=null
    @ApiModelProperty(value = "信息")
    var msg:String?=null
    constructor(code:Int,msg:String):super(msg){
        this.code = code
        this.msg = msg
    }
}