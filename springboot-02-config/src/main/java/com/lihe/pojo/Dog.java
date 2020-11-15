package com.lihe.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {
//    @Value("旺财")
    private String firstName;
//    @Value("3")
    private Integer age;

    public Dog(String name, Integer age) {
        this.firstName = name;
        this.age = age;
    }

    public Dog() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
