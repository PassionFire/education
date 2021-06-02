package com.offcn.service;

import com.offcn.entity.CourseUser;
import com.offcn.utils.PageUtils;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-02 10:05
 */
public interface CourseUserService {
    PageUtils<CourseUser> find(int currentPage, int pageSize, String search);

    int updateCourseById(String cid, String id);

    boolean batchDel(String[] ids);
}
