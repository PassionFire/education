package com.offcn.dao;

import com.offcn.entity.CourseUser;
import com.offcn.utils.BaseDao;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-02 10:06
 */
public class CourseUserDaoImpl extends BaseDao<CourseUser> implements CourseUserDao {
    @Override
    public List<CourseUser> find(String sql, Object... params) {
        return getMore(sql,CourseUser.class,params);
    }

    @Override
    public int updateCourseById(String cid, String id) {
        return update("update course_user set cid = ? where id = ?",cid,id);
    }

    @Override
    public int delete(String id) {
        return update("delete from course_user where id = ?",id);
    }
}
