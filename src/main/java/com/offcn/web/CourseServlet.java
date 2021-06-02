package com.offcn.web;

import com.offcn.entity.Course;
import com.offcn.service.CourseService;
import com.offcn.service.CourseServiceImpl;
import com.offcn.utils.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-31 18:55
 */
@WebServlet("/course")
@MultipartConfig
public class CourseServlet extends BaseServlet {

    CourseService courseService = new CourseServiceImpl();
    ResultVO resultVO = null;
    public void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = "";
        try {
            fileName = FileUploadUtils.upload(req);
            if (fileName.contains(".jpg") || fileName.contains(".png") || fileName.contains(".jpeg")){
                resultVO = new ResultVO(201,"上传图片成功",fileName);
            }else {
                resultVO = new ResultVO(202,"上传视频成功",fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO(500,"上传文件失败",null);
        }finally {
            //将文件名响应回前端
            JsonUtils.sendByJson(resp,resultVO);
        }
    }

    public void removeFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        File file = new File("F:\\upload", fileName);
        boolean delete = file.delete();
        System.out.println(delete);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.populate(course,req.getParameterMap());
        boolean b = courseService.add(course);
        if (b){
            resultVO = new ResultVO(200,"添加课程成功",null);
        }else {
            resultVO = new ResultVO(500,"添加课程失败",null);
        }
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVO));
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        PageUtils<Course> pageUtils =  courseService.findByPage(currentPage,pageSize,search);
        if(pageUtils!=null){
            resultVO = new ResultVO(200,"查询成功",pageUtils);
        }else{
            resultVO = new ResultVO(500,"查询失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void findAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Course> courseList =  courseService.findAllCourse();
        if(courseList!=null){
            resultVO = new ResultVO(200,"查询成功",courseList);
        }else{
            resultVO = new ResultVO(500,"查询失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.populate(course,req.getParameterMap());
        boolean b = courseService.update(course);
        if (b){
            resultVO = new ResultVO(200,"修改课程成功",null);
        }else {
            resultVO = new ResultVO(500,"修改课程失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void batchDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String[] cids = req.getParameterValues("cid");
        boolean b = courseService.delete(cids);
        if (b){
            resultVO = new ResultVO(200,"删除课程成功",null);
        }else {
            resultVO = new ResultVO(500,"删除课程失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

}
