package com.offcn.entity;

import java.io.Serializable;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 10:10
 */
public class User implements Serializable {
    private int uid; // 编号
    private String name; // 真实姓名
    private String phone; // 手机号
    private int age; // 年龄
    private int sex; // 性别 0：男  1：女
    private String username; // 用户名
    private String password; // 用户密码
    private String picture; // 用户头像路径
    private int status = 1; // 用户状态 1：启用 2：禁用
    private String createtime; // 注册时间
    private int role = 0; // 用户角色 0：学员 1：管理员

    public User(int uid, String name, String phone, int age, int sex, String username, String password, String picture, int status, String createtime, int role) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.status = status;
        this.createtime = createtime;
        this.role = role;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
