package com.tencent.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "nacos-provider")//调用的提供者的名称
public interface ConsumerHTTPApi {

    @GetMapping("/provider/echo/{msg}")
    public String echoMsg(@PathVariable String msg);

}
