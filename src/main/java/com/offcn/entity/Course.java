package com.offcn.entity;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-31 19:16
 */
public class Course {
    private int cid;
    private String courseName;
    private String descs;
    private int courseType;
    private String courseImage;
    private String courseVideo;
    private String coursePrice;
    private int status; // 课程状态 0：未上架  1：上架 2：下架
    private String createTime;

    public Course() {
    }

    public Course(int cid, String courseName, String descs, int courseType, String courseImage, String courseVideo, String coursePrice, int status, String createTime) {
        this.cid = cid;
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.courseImage = courseImage;
        this.courseVideo = courseVideo;
        this.coursePrice = coursePrice;
        this.status = status;
        this.createTime = createTime;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", courseName='" + courseName + '\'' +
                ", descs='" + descs + '\'' +
                ", courseType=" + courseType +
                ", courseImage='" + courseImage + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", coursePrice='" + coursePrice + '\'' +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
