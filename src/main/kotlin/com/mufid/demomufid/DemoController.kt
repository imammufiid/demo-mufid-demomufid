package com.mufid.demomufid

import com.mufid.demomufid.BaseResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class DemoController {

    @GetMapping("/ping")
    fun ping(): BaseResponse<String> {
        return BaseResponse(true, "success", "Hello World")
    }
}