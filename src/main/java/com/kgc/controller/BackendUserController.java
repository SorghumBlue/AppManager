package com.kgc.controller;

import com.kgc.pojo.BackendUser;
import com.kgc.service.BackendUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/backUser")
public class BackendUserController {
    @Resource
    BackendUserService backendUserService;
    @RequestMapping("/login")
    public String login(){
        return "backendlogin";
    }
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String dologin(HttpSession session,@RequestParam String userCode, String userPassword){
        BackendUser user = backendUserService.selectByLogin(userCode, userPassword);
        System.out.println(user);
        if(user != null) {
            session.setAttribute("user",user);
            return "/backend/main";
        }else {
            return "redirect:/backUser/login";
        }
    }

}
