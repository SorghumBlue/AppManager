package com.kgc.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kgc.pojo.AppCategory;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.AppVersion;
import com.kgc.pojo.DataDictionary;
import com.kgc.service.AppInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/AppInfo")
public class AppInfoController {
    @Resource
    AppInfoService appInfoService;

    @RequestMapping("/contextPath")
    public String appcheck(HttpSession session, @RequestParam(required = false) Integer aid, @RequestParam(required = false) Integer vid) {
        aid = 58;
        vid = 40;
        AppInfo appInfo = appInfoService.selectById(aid, vid);
        AppVersion appVersion = appInfo.getAppVersion();
        session.setAttribute("appVersion", appVersion);
        session.setAttribute("appInfo", appInfo);
        //查找所属平台
        Integer valueid = appInfo.getFlatformid();
        DataDictionary data = appInfoService.selectByvalueid(valueid);
        String valuename = data.getValuename();
        session.setAttribute("floatform",valuename);
        //APP状态
        Integer status = appInfo.getStatus();
        DataDictionary dataDictionary = appInfoService.selectByStatus(status);
        String statusname = dataDictionary.getValuename();
        session.setAttribute("status",statusname);
        //游戏分类
        List<AppCategory> list = appInfoService.selectBycategory(appInfo.getCategorylevel1(), appInfo.getCategorylevel2(), appInfo.getCategorylevel3());
        session.setAttribute("list",list);
        return "/backend/appcheck";
    }
    @RequestMapping("checksave")
    public String save(Integer id,Integer status){
        //修改审核状态
        int update = appInfoService.updateStatus(id, status);
        return "redirect:/AppInfo/contextPath";
    }
// 修改APPInfo
    @RequestMapping("/appinfomodify")
    public String modify(HttpSession session,@RequestParam(required = false,defaultValue = "56") Integer id){
        AppInfo appInfo = appInfoService.selectName(id);
        session.setAttribute("appInfo",appInfo);
        System.out.println(appInfo);
        return "/developer/appinfomodify";
    }
}
