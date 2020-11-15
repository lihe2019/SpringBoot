package com.lihe.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 授权
    // 链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人都可以访问，但是功能页只有对应有权限的人才能访问
        // 请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限会调到登录页面,需要开启登录的页面
        http.formLogin();
        http.logout().logoutSuccessUrl("/index");// 注销后跳转的页面

        // 放置网站攻击： get---》 post
        http.csrf().disable();

        // 开启记住我,默认保存两周
        http.rememberMe();

    }

    // 认证 springboot2.1.X可以直接使用
    // 在SpringSecurity5.0+ 新增了很多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lihe").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3");

    }
}
