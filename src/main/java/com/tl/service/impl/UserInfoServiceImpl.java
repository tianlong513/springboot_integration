package com.tl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.entity.UserInfo;
import com.tl.mapper.UserInfoMapper;
import com.tl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tl
 * @description:
 * @author: tianlong
 * @create: 2018-12-10 17:11
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Object UserInfoList() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
//        wrapper.eq("name","张三");
        IPage<UserInfo> page = new Page<>();
        page.setTotal(0);
        page.setSize(2);
        IPage<UserInfo> userInfors = userInfoMapper.selectPage(page,wrapper);
        return userInfors;
    }

    @Override
    public List<UserInfo> userList() {
        return userInfoMapper.userList();
    }
}
