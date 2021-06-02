package com.offcn.dao;

import com.offcn.entity.CourseUser;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-02 10:06
 */
public interface CourseUserDao {
    List<CourseUser> find(String sql,Object...params);

    int updateCourseById(String cid, String id);

    int delete(String id);
}
