package com.kgc.controller;

import com.kgc.pojo.DevUser;
import com.kgc.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/devUser")
public class DevUserLoginController {
    @Resource
    private DevUserService devUserService;

    @RequestMapping("/login")
    public String login() {
        return "devlogin";
    }

    @RequestMapping("/dologin")
    public String dologin(@RequestParam String devCode, String devPassword, HttpSession session) {
        DevUser devUser = devUserService.selectOneByDevCode(devCode, devPassword);
        if (devUser != null) {
            session.setAttribute("user",devUser);
            return "developer/main";
        }
        session.setAttribute("error","用户名或密码错误");
        return "redirect:/devUser/login";
    }
}
