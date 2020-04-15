package com.zhiyou.weixin.dao;

import com.zhiyou.weixin.pojo.UserPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Insert("insert into users (username,password,time) values (#{username},#{password},now())")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="userId")
    void insertUserPojo(UserPojo userPojo);

    @Select("select userId,username,password,time from users where username=#{username}")
    UserPojo getByUserName(String username);

    @Select("select userId from users where username = #{username}")
    int getUserIdByUserName(String username);
}
