package com.kgc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kgc.dao.AppCategoryMapper;
import com.kgc.dao.DataDictionaryMapper;
import com.kgc.pojo.AppCategory;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.DataDictionary;
import com.kgc.service.AppInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/appManager")
public class BackendManagerController {
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;
    @Resource
    private AppCategoryMapper appCategoryMapper;
    @RequestMapping("/showList")
    public String showList(HttpSession session,
                           @RequestParam(required = false) Integer pageIndex,
                           @RequestParam(required = false) String querySoftwareName,
                           @RequestParam(required = false)Integer queryFlatformId,
                           @RequestParam(required = false)Integer queryCategoryLevel1,
                           @RequestParam(required = false)Integer queryCategoryLevel2,
                           @RequestParam(required = false)Integer queryCategoryLevel3){
        if(pageIndex==null){
            pageIndex=1;
        }
        EntityWrapper wrapper = new EntityWrapper();
        if(querySoftwareName!=null){
            System.err.println(querySoftwareName);
            wrapper.like("softwareName",querySoftwareName);
        }
        if(queryFlatformId!=null){
            wrapper.eq("flatformId",queryFlatformId);
        }
        if(queryCategoryLevel1!=null){
            wrapper.eq("categoryLevel1",queryCategoryLevel1);
        }
        if(queryCategoryLevel2!=null){
            wrapper.eq("categoryLevel2",queryCategoryLevel2);
        }
        if(queryCategoryLevel3!=null){
            wrapper.eq("categoryLevel3",queryCategoryLevel3);
        }
        Page<AppInfo> page = appInfoService.selectAll(5, pageIndex,wrapper);
        List<AppCategory> categoryLevel1List = appCategoryMapper.selectList(new EntityWrapper<AppCategory>().isNull("parentId"));
        List<AppCategory> categoryLevel2List = appCategoryMapper.selectList(new EntityWrapper<AppCategory>().in("parentId", Arrays.asList(1,2)));
        List<AppCategory> categoryLevel3List = appCategoryMapper.selectList(new EntityWrapper<AppCategory>().in("parentId", Arrays.asList(3,4,19,20,21,22)));
        List<DataDictionary> flatFormList = dataDictionaryMapper.selectList(new EntityWrapper<DataDictionary>().eq("typeCode", "APP_FLATFORM"));
        session.setAttribute("flatFormList",flatFormList);
        session.setAttribute("categoryLevel1List",categoryLevel1List);
        session.setAttribute("categoryLevel2List",categoryLevel2List);
        session.setAttribute("categoryLevel3List",categoryLevel3List);
        session.setAttribute("page",page);
        return "backend/applist";
    }
    @RequestMapping("/categorylevel2list")
    @ResponseBody
    public Object categorylevel2list(@RequestParam(required = false) Integer pid){
        List<AppCategory> appCategories = appInfoService.selectById(pid);
        return appCategories;
    }
    @RequestMapping("categorylevel3list")
    @ResponseBody
    public Object categorylevel3list(@RequestParam(required = false) Integer pid){
        List<Integer> list = new ArrayList<>();
        switch (pid){
            case 1:
                list = Arrays.asList(3, 4);
                break;
            case 2:
                list = Arrays.asList(19, 20, 21, 22);
                break;
        }
        List<AppCategory> appCategories = appInfoService.selectByList(list);
        for (AppCategory appCategory : appCategories) {
            System.out.println(appCategory);
        }
        return appCategories;
    }
}

