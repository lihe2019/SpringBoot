package com.lihe.spring07swaggerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    // /error 默认请求

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
