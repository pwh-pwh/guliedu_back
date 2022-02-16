package com.coderpwh.oss.controller

import com.coderpwh.commonutils.R
import com.coderpwh.oss.service.OssService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.annotation.Resource

@RestController
@RequestMapping("/edu/oss")
@CrossOrigin
class OssController {
    @Resource
    lateinit var ossService: OssService
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    fun uploadOssFile(
        @ApiParam(name = "file", value = "文件", required = true, type = "file")
        @RequestParam("file")
        file:MultipartFile
    ):R {
        var url = ossService.uploadFileAvatar(file)
        return R.ok().data("url",url)
    }


}