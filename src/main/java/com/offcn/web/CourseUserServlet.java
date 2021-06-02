package com.offcn.web;

import com.offcn.entity.CourseUser;
import com.offcn.service.CourseUserService;
import com.offcn.service.CourseUserServiceImpl;
import com.offcn.utils.BaseServlet;
import com.offcn.utils.JsonUtils;
import com.offcn.utils.PageUtils;
import com.offcn.utils.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-02 10:03
 */
@WebServlet("/courseUser")
public class CourseUserServlet extends BaseServlet {

    private CourseUserService courseUserService = new CourseUserServiceImpl();
    ResultVO resultVO = null;
    /**
     * 分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        PageUtils<CourseUser> pageUtils = courseUserService.find(currentPage,pageSize,search);
        if (pageUtils!=null){
            resultVO = new ResultVO(200,"查询成功",pageUtils);
        }else {
            resultVO = new ResultVO(500,"查询成功",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void updateCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String id = req.getParameter("id");
        int row = courseUserService.updateCourseById(cid,id);
        if (row > 0){
            resultVO = new ResultVO(200,"修改课程成功",null);
        }else {
            resultVO = new ResultVO(500,"修改课程失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

    public void batchDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("id");
        boolean b = courseUserService.batchDel(ids);
        if (b){
            resultVO = new ResultVO(200,"删除课程成功",null);
        }else {
            resultVO = new ResultVO(500,"删除课程失败",null);
        }
        JsonUtils.sendByJson(resp,resultVO);
    }

}
