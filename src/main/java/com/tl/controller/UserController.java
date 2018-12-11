package com.tl.controller;

import com.tl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tl
 * @description:
 * @author: tianlong
 * @create: 2018-12-10 17:18
 **/
@RestController
public class UserController{

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "user")
    public Object user() {
        return userInfoService.UserInfoList();
    }

    @RequestMapping(value = "user2")
    public Object user2() {
        return userInfoService.userList();
    }
}
