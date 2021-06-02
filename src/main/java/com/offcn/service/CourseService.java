package com.offcn.service;

import com.offcn.entity.Course;
import com.offcn.utils.PageUtils;

import java.util.List;


/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 11:33
 */
public interface CourseService {

    /**
     * 添加课程
     * @param course
     * @return
     */
    boolean add(Course course);

    /**
     * 查询课程
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    PageUtils<Course> findByPage(int currentPage, int pageSize, String search);

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    boolean update(Course course);

    /**
     * 删除课程信息
     * @param cids
     * @return
     */
    boolean delete(String[] cids);

    List<Course> findAllCourse();
}
