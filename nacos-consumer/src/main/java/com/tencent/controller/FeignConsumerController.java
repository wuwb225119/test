package com.tencent.controller;

import com.tencent.api.ConsumerHTTPApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {


    @Autowired
    private ConsumerHTTPApi consumerHTTPApi;

    @GetMapping("/consumer/feign")
    public String echoFeignMsg( ){
        return consumerHTTPApi.echoMsg("hello");
    }

}
