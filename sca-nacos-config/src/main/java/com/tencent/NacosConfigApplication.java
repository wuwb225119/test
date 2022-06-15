package com.tencent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class,args);
    }


    @RefreshScope
    @RestController
    @RequestMapping("/config/")
public class NacosConfigController{
        @Value("${logging.com.tencent:info}")
        private String LogLevel;

        @RequestMapping("/doGetLevel")
        public String doGetLevel(){
            return "log level is"+LogLevel;
        }
    }
}
