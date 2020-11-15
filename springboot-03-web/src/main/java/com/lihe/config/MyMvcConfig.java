package com.lihe.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
// 如果你想diy一些定制化的功能，只要写这个组件，然后将它交给Springboot，springboot就会帮我们自动装配
// 扩展 springmvc 肯定会过DispatchServlet

// 如果我们要扩展springmvc，官方建议我们这样去做，写类 设置配置

@Configuration
//@EnableWebMvc // 这个注解就是导入一个类 @Import({DelegatingWebMvcConfiguration.class})：从容器中获取所有的webmvcconfig：
public class MyMvcConfig implements WebMvcConfigurer {
    // public interface ViewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器


    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 自定义一个自己的视图解析器
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/index.html," , "/", "/user/login", "/css/*", "/js/**", "/img/**");
    }




}


