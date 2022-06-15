package com.tencent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String applicationName;


    @GetMapping("/consumer/echo")
    public String doTest(){
/*        ServiceInstance serviceInstance=loadBalancerClient.choose("nacos-provider");

        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/provider/echo/"+applicationName+"-"+serviceInstance.getPort();*/

        //用@LoadBalanced注解后
        String url="http://nacos-provider/provider/echo/"+applicationName;
        System.out.println(url);
        return  restTemplate.getForObject(url,String.class);
    }


}
