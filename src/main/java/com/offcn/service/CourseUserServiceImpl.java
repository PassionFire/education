package com.offcn.service;

import com.offcn.dao.*;
import com.offcn.entity.Course;
import com.offcn.entity.CourseUser;
import com.offcn.entity.User;
import com.offcn.utils.PageUtils;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-02 10:05
 */
public class CourseUserServiceImpl implements CourseUserService {

    private CourseUserDao courseUserDao = new CourseUserDaoImpl();
    private CourseDao courseDao = new CourseDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    @Override
    public PageUtils<CourseUser> find(int currentPage, int pageSize, String search) {
        StringBuilder sb = new StringBuilder("select cu.* from course_user as cu,user as u where cu.uid = u.uid and u.name like ?");
        List<CourseUser> list =  courseUserDao.find(sb.toString(),"%"+search+"%");
        int total = list==null?0:list.size();
        //分页
        sb.append("limit ?,?");
        List<CourseUser> courseUserList = courseUserDao.find(sb.toString(), "%" + search + "%", (currentPage - 1) * pageSize, pageSize);
        for (CourseUser courseUser : courseUserList) {
            User user = userDao.findById(courseUser.getUid());
            courseUser.setUser(user);
            Course course = courseDao.findById(courseUser.getCid());
            courseUser.setCourse(course);
        }
        PageUtils<CourseUser> pageUtils = new PageUtils<>(pageSize,currentPage,total,courseUserList);
        return pageUtils;
    }

    @Override
    public int updateCourseById(String cid, String id) {
        return courseUserDao.updateCourseById(cid,id);
    }

    @Override
    public boolean batchDel(String[] ids) {
        try {
            for (String id : ids){
                int row = courseUserDao.delete(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
