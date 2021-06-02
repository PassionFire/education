package com.offcn.entity;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 14:21
 */
public class CourseUser {
    private Course course;
    private User user;
    private int id;
    private int cid;
    private int uid;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
