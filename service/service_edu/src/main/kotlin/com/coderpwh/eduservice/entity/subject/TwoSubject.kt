package com.coderpwh.eduservice.entity.subject

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class TwoSubject:Serializable {
    var id:String? = null
    @JsonProperty("label")
    var title :String?= null

}