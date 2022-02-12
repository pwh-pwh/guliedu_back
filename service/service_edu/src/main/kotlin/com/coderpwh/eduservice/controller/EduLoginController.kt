package com.coderpwh.eduservice.controller

import com.coderpwh.commonutils.R
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@CrossOrigin
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
        map["avatar"] = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
        map["introduction"] = "i am  coder"
        return R.ok().data(map)
    }

    @PostMapping("/logout")
    fun logout():R {

        return R.ok()
    }


}