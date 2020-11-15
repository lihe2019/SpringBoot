package com.lihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// SpringBootApplication 标注这个类是SpringBoot的应用
@SpringBootApplication
public class Springboot01HelloworldApplication {
    // 将SpringBoot启动
    public static void main(String[] args) {
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}
