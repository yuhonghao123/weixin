package com.zhiyou.weixin.service.impl;

import com.zhiyou.weixin.dao.UserDao;
import com.zhiyou.weixin.pojo.UserPojo;
import com.zhiyou.weixin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserPojo register(String userName, String password) {
        UserPojo preUserPo=userDao.getByUserName(userName);
        if (preUserPo!=null){
            throw new RuntimeException("repeat of user name");
        }
        UserPojo userPojo=new UserPojo();
        userPojo.setUsername(userName);
        userPojo.setPassword(password);
        userDao.insertUserPojo(userPojo);
        return userPojo;
    }
}
