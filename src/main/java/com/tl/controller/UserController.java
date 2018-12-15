package com.tl.controller;

import com.tl.entity.UserInfo;
import com.tl.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: tl
 * @description:
 * @author: tianlong
 * @create: 2018-12-10 17:18
 **/
@Api(value = "用户接口", description = "user服务API根目录")
@RestController
public class UserController {
    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "mybatisPlus不写SQL获取用户列表", notes = "填写用户id查询指定信息，不写查询全部")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", dataType = "string", required = false)
    )
    @GetMapping(value = "user")
    public Object user(String id) {
        return userInfoService.UserInfoList(id);
    }

    @ApiOperation(value = "mybatisPlus写SQL获取用户列表", notes = "")
    @GetMapping(value = "user2")
    public Object user2() {
        return userInfoService.userList();
    }

    @ApiOperation(value = "mybatisPlus添加用户信息")
    /*@ApiImplicitParams({
            @ApiImplicitParam(value = "用户名", required = true, dataType = "string", name = "name", paramType = "query"),
            @ApiImplicitParam(value = "密码", required = true, dataType = "string", name = "password", paramType = "query"),
            @ApiImplicitParam(value = "手机号", required = true, dataType = "string", name = "phone    ", paramType = "query")
    })*/
    @PostMapping(value = "save_user")
    public Object save_user(UserInfo userInfo) {
        userInfo.setCreateDate(new Date());
        return userInfoService.save(userInfo);
    }
}
