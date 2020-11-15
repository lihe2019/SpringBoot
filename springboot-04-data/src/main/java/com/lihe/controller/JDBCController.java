package com.lihe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    // 查询数据库的所有信息
    // 没有实体类，数据库中的东西怎么获取？ Map
    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> listMaps = jdbcTemplate.queryForList(sql);
        return listMaps;
    }

    @GetMapping("/addUser")
    // 自动提交了事务  声明式事务
    public String addUser(){
        String sql = "insert into mybatis.user(id, name, pwd) values(20, 'lihe666', '1231564')";
        jdbcTemplate.update(sql);
        return "update ok";
    }

    @GetMapping("/updateUser/{id}")
    // 自动提交了事务  声明式事务
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name =? , pwd = ? where id= " + id;
        // 封装
        Object[] objects = new Object[2];
        objects[0] = "小名2";
        objects[1] = "zzzzzz";
        jdbcTemplate.update(sql, objects[0], objects[1]);
        return "update user ok";
    }

    @GetMapping("/deleteUser/{id}")
    // 自动提交了事务  声明式事务
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete ok";
    }

}
