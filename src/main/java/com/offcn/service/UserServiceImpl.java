package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.dao.UserDaoImpl;
import com.offcn.entity.User;
import com.offcn.utils.PageUtils;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 14:05
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean add(User user) {
        return userDao.add(user)>0;
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @Override
    public PageUtils<User> findByPage(int currentPage, int pageSize, String search) {
        StringBuilder sb = new StringBuilder("select * from user where name like ? ");
        int count = userDao.find(sb.toString(),"%"+search+"%").size();
        sb.append(" limit ?,?");
        List<User> userList = userDao.find(sb.toString(), "%"+search+"%", (currentPage - 1) * pageSize, pageSize);
        PageUtils<User> pageUtils = new PageUtils<>(pageSize,currentPage,count,userList);
        return pageUtils;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUserByUid(user);
    }

    /**
     * 批量删除
     * @param uids
     * @return
     */
    @Override
    public boolean batchDel(String[] uids) {
        try {
            for (String uid : uids) {
                int i =   userDao.deleteById(uid);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return true;
    }
}
