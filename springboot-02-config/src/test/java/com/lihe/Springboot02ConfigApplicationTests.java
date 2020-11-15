package com.lihe;

import com.lihe.pojo.Dog;
import com.lihe.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private Dog dog;

    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
//        Person{name='lihe',
//        age=18,
//        happy=false,
//        birth=Sat Nov 02 00:00:00 CST 2019,
//        maps={k1=v1, k2=v2},
//        list=[code, music, girl],
//        dog=Dog{name='wangcai', age=3}}


    }

    @Test
    public void test1(){
        System.out.println(dog);
    }

}
