package com.offcn.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-01 11:43
 */

/**
 * 以Json响应回前端
 */
public class JsonUtils{
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static void sendByJson(HttpServletResponse resp,ResultVO resultVO) throws ServletException, IOException {
        resp.getWriter().print(objectMapper.writeValueAsString(resultVO));
    }
}
