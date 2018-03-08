package com.hackmind.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackmind.entity.User;
import com.hackmind.service.IUserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userServiceTwo")
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        req.setCharacterEncoding("UTF-8");
        rep.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        User user = this.userService.selectUser(id);
        ObjectMapper objectMapper=new ObjectMapper();
        rep.getWriter().write(objectMapper.writeValueAsString(user));
        rep.getWriter().close();
    }
}
