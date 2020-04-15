package com.zhiyou.weixin.service;


import com.zhiyou.weixin.pojo.UserPojo;

public interface RegisterService {
    UserPojo register(String userName,String password);
}
