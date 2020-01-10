package com.kgc.controller;

import com.kgc.pojo.AppInfo;
import com.kgc.pojo.AppVersion;
import com.kgc.service.AppInfoService;
import com.kgc.service.AppVersionService;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/version")
public class AppVersionController {
    @Resource
    AppVersionService versionService;
    @Resource
    AppInfoService appInfoService;

    @RequestMapping("/add")
    public String add(HttpSession session) {
        List<AppVersion> appVersions = versionService.selectAll();
        session.setAttribute("appVersionList", appVersions);
        return "/developer/appversionadd";
    }

    @RequestMapping("/addversionsave")
    public String save(AppVersion appVersion) {
        versionService.add(appVersion);
        return "redirect:/version/add";
    }

    @RequestMapping("/modify")
    public String modify(HttpSession session, Integer id) {
        if (id == null) {
            id = 42;
        }
        List<AppVersion> appVersions = versionService.selectAll();
        session.setAttribute("appVersionList", appVersions);
        AppVersion appVersion = versionService.selectById(id);
        session.setAttribute("appVersion", appVersion);
        System.out.println(appVersion);
        return "/developer/appversionmodify";
    }

    @RequestMapping("/appversionmodifysave")
    public String modifySave(@RequestParam Long id,
                             @RequestParam BigDecimal versionSize,
                             @RequestParam String versioninfo) {

        AppVersion appVersion = new AppVersion();
        appVersion.setId(id);
        appVersion.setVersioninfo(versioninfo);
        appVersion.setVersionsize(versionSize);
        versionService.updateByid(appVersion);
        System.out.println(appVersion);
        return "redirect:/version/modify";
    }

}