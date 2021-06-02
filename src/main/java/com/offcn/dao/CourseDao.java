package com.offcn.dao;

import com.offcn.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 11:32
 */
public interface CourseDao {

    /**
     * 添加课程
     * @param course
     * @return
     */
    int add(Course course);

    /**
     * 查询课程
     * @param sql
     * @param params
     * @return
     */
    List<Course> find(String sql, Object...params);

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 删除课程信息
     * @param id
     * @return
     */
    int delete(String id);

    Course findById(int cid);

    List<Course> findAllCourse();
}
