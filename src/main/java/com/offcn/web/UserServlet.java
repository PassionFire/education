package com.offcn.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import com.offcn.service.UserServiceImpl;
import com.offcn.utils.BaseServlet;
import com.offcn.utils.JsonUtils;
import com.offcn.utils.PageUtils;
import com.offcn.utils.ResultVO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-05-29 10:11
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

//    ObjectMapper objectMapper = new ObjectMapper();
    ResultVO resultVo = null;
    UserService userService = new UserServiceImpl();

    /**
     * 登录
     * @param request
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("imageCode");
        HttpSession session = request.getSession();
        String verCode = (String) session.getAttribute("verCode");
        if(code.equalsIgnoreCase(verCode)){
            User user = userService.login(username, password);
            if(user!=null){
                if(user.getRole()==1){
                    resultVo = new ResultVO(4,"登录成功!!",user);
                    session.setAttribute("user",user);
                }else{
                    //权限不足
                    resultVo = new ResultVO(3,"权限不足!!",null);
                }
            }else{
                //账号或密码有误
                resultVo = new ResultVO(2,"账号或密码有误!!",null);
            }
        }else{
            //验证码有误
            resultVo = new ResultVO(1,"验证码有误!!",null);
        }
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }

    /**
     * 获取用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resultVo = new ResultVO(200,"获取用户数据成功",user);
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }

    /**
     * 注销用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resultVo = new ResultVO(200,"退出成功",null);
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }

    /**
     * 添加用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.populate(user,req.getParameterMap());
        boolean b = userService.add(user);
        if (b){
            resultVo = new ResultVO(200,"添加成功",null);
        }else {
            resultVo = new ResultVO(500,"添加失败",null);
        }
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }

    /**
     * 分页查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        PageUtils<User> pageUtils =  userService.findByPage(currentPage,pageSize,search);
        if(pageUtils!=null){
            resultVo = new ResultVO(200,"查询成功",pageUtils);
        }else{
            resultVo = new ResultVO(500,"查询失败",null);
        }
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }

    /**
     * 更新用户
     * @param request
     * @param response
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user,map);
        int row = userService.updateUser(user);
        if (row > 0) {
            resultVo = new ResultVO(200, "更新用户成功", null);
        } else {
            resultVo = new ResultVO(500, "更新用户失败", null);
        }
//        response.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(response,resultVo);
    }

    //批量删除
    public void batchDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String[] uids = req.getParameterValues("uid");
        boolean r = userService.batchDel(uids);
        if(r){
            resultVo = new ResultVO(200,"批量删除成功",null);
        }else{
            resultVo = new ResultVO(500,"批量删除失败",null);
        }
//        resp.getWriter().print(objectMapper.writeValueAsString(resultVo));
        JsonUtils.sendByJson(resp,resultVo);
    }
}
