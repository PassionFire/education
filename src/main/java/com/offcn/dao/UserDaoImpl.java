package com.offcn.dao;

import com.offcn.entity.User;
import com.offcn.utils.BaseDao;

import java.util.Date;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 14:05
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Override
    public User findById(int uid) {
        return getOne("select * from user where uid = ?",User.class,uid);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return getOne("select * from user where username like ? and password like ?",User.class,username,password);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?,now(),?,null)";
        return update(sql,user.getName(),user.getPhone(),user.getAge(),user.getSex(),
                user.getUsername(),user.getPassword(),user.getStatus(),user.getRole());
    }

    /**
     * 查询用户
     * @param sql
     * @param params
     * @return
     */
    @Override
    public List<User> find(String sql, Object... params) {
        return getMore(sql,User.class,params);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public int updateUserByUid(User user) {
        String sql = "update user set name =?,phone=?,age=?,sex=?,username=?,password=?,status=?,createTime=?,role=?,picture=? where uid =?";
        return update(sql,user.getName(),user.getPhone(),user.getAge(),user.getSex(),user.getUsername(),user.getPassword(),
                user.getStatus(),new Date(),user.getRole(),user.getPicture(),user.getUid());
    }

    /**
     * 根据id删除用户
     * @param uid
     * @return
     */
    @Override
    public int deleteById(String uid) {
        return update("delete from user where uid = ?",uid);
    }
}
