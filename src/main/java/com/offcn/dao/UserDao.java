package com.offcn.dao;

import com.offcn.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 14:05
 */
public interface UserDao {

    User findById(int uid);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 查询用户
     * @param sql
     * @param params
     * @return
     */
    List<User> find(String sql, Object...params);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUserByUid(User user);

    /**
     * 根据id删除用户
     * @param uid
     * @return
     */
    int deleteById(String uid);
}
