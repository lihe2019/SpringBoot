package com.lihe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 热部署可以不重启

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
