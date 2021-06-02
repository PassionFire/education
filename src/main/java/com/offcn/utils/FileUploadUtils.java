package com.offcn.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 用于上传文件的工具类
 */
public class FileUploadUtils {
    public static String upload(HttpServletRequest request) throws IOException, ServletException {
        Part myFile = request.getPart("myFile");
        String fileName = myFile.getSubmittedFileName(); //1234.jpg
        fileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));    //.jpg
        File file = new File("F:\\upload");
        if(!file.exists()){
            file.mkdirs();
        }
        File file2 = new File(file,fileName);
        myFile.write(file2.getPath());
        return fileName;
    }
}
