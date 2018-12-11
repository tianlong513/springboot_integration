package com.tl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tl.entity.UserInfo;

import java.util.List;

/**
 * @program: tl
 * @description: 用户数据访问层
 * @author: tianlong
 * @create: 2018-12-10 16:56
 **/
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    List<UserInfo> userList();
}
