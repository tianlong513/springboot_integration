package com.tl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.entity.UserInfo;
import com.tl.mapper.UserInfoMapper;
import com.tl.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tl
 * @description:
 * @author: tianlong
 * @create: 2018-12-10 17:11
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Object UserInfoList(String id) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        if (id != null) {
            wrapper.eq("id", id);
        }
        IPage<UserInfo> page = new Page<>();
        page.setTotal(0);
        page.setSize(2);
        IPage<UserInfo> userInfors = userInfoMapper.selectPage(page, wrapper);
        return userInfors.getRecords();
    }

    @Override
    public List<UserInfo> userList() {
        return userInfoMapper.userList();
    }

    @Override
    public Object save(UserInfo userInfo) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Integer row = userInfoMapper.insert(userInfo);
            resultMap.put("message", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "添加失败");
            logger.error("用户添加失败" + e.getMessage());

        }
        return resultMap;
    }
}
