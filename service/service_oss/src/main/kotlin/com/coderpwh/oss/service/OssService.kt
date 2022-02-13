package com.coderpwh.oss.service

import org.springframework.web.multipart.MultipartFile

interface OssService {
    fun uploadFileAvatar(file:MultipartFile):String
}