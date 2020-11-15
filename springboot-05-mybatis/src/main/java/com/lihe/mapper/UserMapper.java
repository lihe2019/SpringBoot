package com.lihe.mapper;

import com.lihe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper // 表示这是一个mybatis mapper 或者在run函数 加一个 @MapperScan("com.lihe.mapper")
@Repository // DAO
public interface UserMapper {


    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
