package com.offcn.service;

import com.offcn.dao.CourseDao;
import com.offcn.dao.CourseDaoImpl;
import com.offcn.entity.Course;
import com.offcn.utils.PageUtils;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 11:33
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public boolean add(Course course) {
        return courseDao.add(course)>0;
    }

    /**
     * 查询课程
     * @param currentPage
     * @param pageSize
     * @param search
     * @return
     */
    @Override
    public PageUtils<Course> findByPage(int currentPage, int pageSize, String search) {
        StringBuilder sb = new StringBuilder("select * from course where courseName like ? ");
        int count = courseDao.find(sb.toString(),"%"+search+"%").size();
        sb.append(" limit ?,?");
        List<Course> courseList = courseDao.find(sb.toString(), "%"+search+"%", (currentPage - 1) * pageSize, pageSize);
        PageUtils<Course> pageUtils = new PageUtils<>(pageSize,currentPage,count,courseList);
        return pageUtils;
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @Override
    public boolean update(Course course) {
        return courseDao.updateCourse(course)>0;
    }

    /**
     * 删除课程
     * @param cids
     * @return
     */
    @Override
    public boolean delete(String[] cids) {
        try {
            for (String id : cids){
                int i = courseDao.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }
}
