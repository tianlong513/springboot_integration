package com.tl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.entity.UserInfo;

import java.util.List;

/**
 * @program: tl
 * @description:
 * @author: tianlong
 * @create: 2018-12-10 17:10
 **/
public interface UserInfoService{
    public Object UserInfoList(String id);

    List <UserInfo> userList();

    Object save(UserInfo userInfo);
}
