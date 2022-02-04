package com.coderpwh.eduservice.controller

import com.coderpwh.commonutils.R
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/eduservice/user")
class EduLoginController {

    val log:Logger = LoggerFactory.getLogger(EduLoginController::class.java)

    @PostMapping("/login")
    fun login(@RequestBody map: Map<String,String>): R {
        log.info(map.get("username"))
        log.info(map.get("password"))
        return R.ok().data("token","admin")
    }

    @GetMapping("/info")
    fun info(@RequestParam token:String): R {
        log.info(token)
        val map:MutableMap<String,String> = HashMap()
        map["name"] = "coderpwh"
        map["avatar"] = "https://img2.woyaogexing.com/2022/02/03/020b999719ee485db7ffe8150b96900d!400x400.jpeg"
        return R.ok().data(map)
    }

}