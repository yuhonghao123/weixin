package com.zhiyou.weixin.controller;

import com.zhiyou.weixin.pojo.UserPojo;
import com.zhiyou.weixin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    @ResponseBody
    public UserPojo register(@RequestParam("user_name") String userName,@RequestParam("pass_word")String password){
        UserPojo userPojo=registerService.register(userName, password);
        return userPojo;
    }
}
