package com.tl.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: tl
 * @description: 用户实体类
 * @author:
 * @create: 2018-12-10 16:19
 **/

//@ApiModel(value = "user_info", description = "用户对象")
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    private String id;

    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "123456")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
