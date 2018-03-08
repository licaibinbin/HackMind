package com.hackmind.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/*
 文件上传测试
 Created by lcb
        User: Administrator
        Date: 2018/3/8
        Time: 22:38
 */
@Controller
@RequestMapping({"/file"})
public class FileController {

    //通过spring-mybatis.xml 配置自定义属性,在此进行注册使用
    @Value("${directory.path}")
    private String path;

    @RequestMapping(value = {"/fileUpload"}, method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        try {
            if (file.isEmpty()) {
                return "error";
            }
            String filename = file.getOriginalFilename();
//            String path="/upload/";
            String savePath = request.getSession().getServletContext().getRealPath(path);
            File filePath = new File(savePath, filename);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdir();
            }
            file.transferTo(new File(filePath + filename));
            return "/success";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }

    // 跳转方式1   跳转到文件上传页面
    @RequestMapping({"/filePages"})
    public String redirectToPage(HttpServletResponse response) throws IOException {
        return "/files/fileUpload";
    }

    //跳转方式2
//    @RequestMapping({"/filePages"})
//    public ModelAndView redirectToPage()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/files/fileUpload");
//        return modelAndView;
//    }

}
