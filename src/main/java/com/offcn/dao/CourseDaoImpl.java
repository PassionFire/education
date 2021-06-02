package com.offcn.dao;

import com.offcn.entity.Course;
import com.offcn.utils.BaseDao;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 11:33
 */
public class CourseDaoImpl extends BaseDao<Course> implements CourseDao {

    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public int add(Course course) {
        return update("insert into course values(null,?,?,?,?,?,?,?,now())",course.getCourseName()
                ,course.getDescs(),course.getCourseType(),course.getCourseImage(),course.getCourseVideo()
                ,course.getCoursePrice(),course.getStatus());
    }

    /**
     * 查询课程
     * @param sql
     * @param params
     * @return
     */
    @Override
    public List<Course> find(String sql, Object... params) {
        return getMore(sql,Course.class,params);
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @Override
    public int updateCourse(Course course) {
        return update("update course set courseName=?,descs=?,courseType=?," +
               "courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=now() " +
               "where cid = ?",course.getCourseName(),course.getDescs(),course.getCourseType()
                ,course.getCourseImage(),course.getCourseVideo(),course.getCoursePrice()
                ,course.getStatus(),course.getCid());
    }

    /**
     * 删除课程信息
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        return update("delete from course where cid = ?",id);
    }

    /**
     * 根据id查询课程
     * @param cid
     * @return
     */
    @Override
    public Course findById(int cid) {
        return getOne("select * from course where cid = ?",Course.class,cid);
    }

    @Override
    public List<Course> findAllCourse() {
        return getMore("select * from course",Course.class);
    }
}
