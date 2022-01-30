package com.coderpwh.servicebase.handler

import com.coderpwh.commonutils.R
import com.coderpwh.servicebase.exception.GuliException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * 全局异常处理
 */
@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun error(e:Exception): R {
        return R.error().msg(e.message)
    }

    @ResponseBody
    @ExceptionHandler(GuliException::class)
    fun errorForGLError(e:GuliException):R {
        return R.error().msg(e.msg).code(e.code)
    }
}