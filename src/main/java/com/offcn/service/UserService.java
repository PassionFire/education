package com.offcn.service;

import com.offcn.entity.User;
import com.offcn.utils.PageUtils;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 14:05
 */
public interface UserService {

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
    boolean add(User user);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    PageUtils<User> findByPage(int currentPage, int pageSize, String search);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 批量删除
     * @param uids
     * @return
     */
    boolean batchDel(String[] uids);
}
