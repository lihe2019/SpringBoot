package com.lihe.spring07swaggerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 // 开启swagger2
public class SwaggerConfig {

    // 配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev", "test");
        // 获取项目的环境

        // 通过环境监听判断是否处在想要的环境
        boolean isDev = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(isDev) // 是否启用swagger
                .select()
                // 指定要扫描的包 basePackage
                // any 扫描全部
                // none 不扫描
                // withClassAnnotation:扫描类上的注解 参数是一个注解的反射对象 RestController
                // withMethodAnnotation 扫描方法上的注解 GetMapping
                .apis(RequestHandlerSelectors.basePackage("com/lihe/spring07swaggerdemo/controller"))
                // 过滤路径 paths
//                .paths(PathSelectors.ant("/lihe/**"))
                .build();


    }
    // 配置swagger信息=apiinfo
    private ApiInfo apiInfo(){


        // 作者信息
        Contact contact = new Contact("李赫", "lihelearning.top", "911562554@qq.com");

        return new ApiInfo("Lihe swagger API文档",
                "Api 文档",
                "v0.1",
                "localhost",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
