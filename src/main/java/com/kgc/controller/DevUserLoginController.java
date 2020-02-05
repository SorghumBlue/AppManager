package com.kgc.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.kgc.pojo.*;
import com.kgc.service.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/devUser")
public class DevUserLoginController {
    @Resource
    private DevUserService devUserService;


    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryService dataService;
    @Resource
    private AppCategoryService categoryService;
    @Resource
    private AppVersionService versionService;

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


    @RequestMapping("/appinfolist")
    public String appList(HttpSession session,
                          @RequestParam(required = false) Integer pageIndex,
                          @RequestParam(required = false) String querySoftwareName,
                          @RequestParam(required = false) Long queryStatus,
                          @RequestParam(required = false) Long queryFlatformId,
                          @RequestParam(required = false) Long queryCategoryLevel1,
                          @RequestParam(required = false) Long queryCategoryLevel2,
                          @RequestParam(required = false) Long queryCategoryLevel3){
        if(pageIndex == null){
            pageIndex = 1;
        }
        Page<AppInfo> page = appInfoService.selectAllBySome(pageIndex,5,querySoftwareName, queryStatus,
                queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
        List<DataDictionary> status = dataService.findAllStatus();
        List<DataDictionary> allFlat = dataService.findAllFlat();
        List<AppCategory> allLevel1 = categoryService.findAllLevel1();


        session.setAttribute("pages",page);
        session.setAttribute("appInfoList",page.getRecords());
        session.setAttribute("statusList",status);
        session.setAttribute("flatFormList",allFlat);
        session.setAttribute("categoryLevel1List",allLevel1);
        session.setAttribute("querySoftwareName",querySoftwareName);   // 软件名称
        session.setAttribute("queryStatus",queryStatus);          // APP状态
        session.setAttribute("queryFlatformId",queryFlatformId);   // 所属平台
        session.setAttribute("queryCategoryLevel1",queryCategoryLevel1);  // 一级分类
        session.setAttribute("queryCategoryLevel2",queryCategoryLevel2);  // 二级分类
        session.setAttribute("queryCategoryLevel3",queryCategoryLevel3);  // 三级分类

        return "developer/appinfolist";
    }

    @RequestMapping("/level")
    @ResponseBody
    public Object level(@RequestParam(required = false) Integer pid){

        if(pid == 1){
            return  categoryService.findAppLevel2();
        }else if(pid == 2){
            return  categoryService.findGameLevel2();
        }
        return null;
    }
    @RequestMapping("/level3")
    @ResponseBody
    public Object level3(@RequestParam(required = false) Long pid){
        List<AppCategory> list = categoryService.findAllLevel3(pid);
        return list;
    }
    @RequestMapping("/addlevel")
    @ResponseBody
    public Object addlevel(@RequestParam Long pid){

        return categoryService.AddLevel(pid);
    }



    @RequestMapping("/appAdd")
    public String appAdd(HttpSession session){
        List<DataDictionary> allFlat = dataService.findAllFlat();
        List<AppCategory> level1 = appInfoService.selectByPid(Arrays.asList(0));
        List<AppCategory> level2 = appInfoService.selectByPid(Arrays.asList(1,2));
        List<AppCategory> level3 = appInfoService.selectByPid(Arrays.asList(3,4,19,20,21,22));
        session.setAttribute("flatFormList",allFlat);
        session.setAttribute("categoryLevel1List",level1);
        session.setAttribute("categoryLevel2List",level2);
        session.setAttribute("categoryLevel3List",level3);
        return "developer/appinfoadd";
    }
    /*@RequestMapping("/doappAdd")
    @ResponseBody
    public Object doAdd(@RequestParam String tcode){
        return dataService.findSomeAll(tcode);
    }*/

    @RequestMapping(value = "/appinfoaddsave",method = RequestMethod.POST)
    public String addSave(HttpServletRequest request, HttpSession session,
                          @RequestParam String softwareName,
                          @RequestParam String APKName,
                          @RequestParam String supportROM,
                          @RequestParam String interfaceLanguage,
                          @RequestParam BigDecimal softwareSize,
                          @RequestParam Long downloads,
                          @RequestParam Long flatformId,
                          @RequestParam Long categoryLevel1,
                          @RequestParam Long categoryLevel2,
                          @RequestParam Long categoryLevel3,
                          @RequestParam String status,
                          @RequestParam String appInfo
//                          @RequestParam String a_logoPicPath
    ){

        /*if(!file.isEmpty()){
            // 服务器的目录
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"fileUpload");
            System.out.println(path);
            // 文件名
            String fileName = file.getOriginalFilename();
            // 获取文件扩展名
            String suffix = FilenameUtils.getExtension(fileName);
            // 判断文件大小
            if(file.getSize() > 1000000){
                session.setAttribute("fileUploadError","文件不能超过1M");
            }else if(suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("gif")){
                // 新文件名
                String newFileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000000,9000000)+"_logo.png";
                // 在服务器中创建新文件
                File newFile = new File(path,newFileName);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
                try{
                    // 上传
                    file.transferTo(newFile);
                }catch (IOException e){
                    e.printStackTrace();
                    session.setAttribute("fileUploadError","上传失败");
                }

            }else{
                session.setAttribute("fileUploadError","文件格式错误");
            }*/
            appInfoService.insertApp(softwareName,APKName,supportROM,interfaceLanguage,softwareSize,downloads,flatformId,
                    categoryLevel1,categoryLevel2,categoryLevel3,status,appInfo);
        /*}*/
        return "redirect:/devUser/appinfolist";
    }

    @RequestMapping("/apkName")        // 验证apkName
    @ResponseBody
    public AppInfo apkName(@RequestParam String APKName){
        AppInfo in = new AppInfo();
        List<AppInfo> list = appInfoService.findAll();
        if(APKName == null || "".equals(APKName)){
            in.setApkname("empty");
            return in;
        }else {
            for (AppInfo info : list) {
                if (APKName.equals(info.getApkname())) {
                    in.setApkname("exist");
                    return in;
                }

            }
        }
        in.setApkname("noexist");
        return in;
    }
    @RequestMapping("/appview")        // 查看APP
    public String appview(@RequestParam Integer id,HttpSession session){
        AppInfo list = appInfoService.AppView(id);
        List<AppVersion> versions = versionService.findByAppId(list.getId().intValue());
        session.setAttribute("appVersionList",versions);
        session.setAttribute("appInfo",list);
        return "developer/appinfoview";
    }

    @RequestMapping("/delApp")      // 删除APP
    @ResponseBody
    public ReturnInfo delAPP(@RequestParam Integer id){
        ReturnInfo in = new ReturnInfo();
        Integer delApp = appInfoService.delApp(id.intValue());    // 删除app
        if(delApp >= 1){
            in.setDelResult("true");
        }else if(delApp == 0){
            in.setDelResult("false");
        }else{
            in.setDelResult("notexist");
        }
        return in;
    }

    @RequestMapping("/appinfomodify")
    public String appinfomodify(HttpSession session,@RequestParam(required = false,defaultValue = "56") Integer id){
        AppInfo appInfo = appInfoService.selectName(id);
        session.setAttribute("appInfo",appInfo);
        return "developer/appinfomodify";
    }
    @RequestMapping("/appinfomodifysave")
    public String appinfomodifysave(@RequestParam Integer id,
                                    @RequestParam String softwareName,
                                    @RequestParam String APKName,
                                    @RequestParam String supportROM,
                                    @RequestParam String interfaceLanguage,
                                    @RequestParam BigDecimal softwareSize,
                                    @RequestParam Long downloads,
                                    @RequestParam Long flatformId,
                                    @RequestParam Long categoryLevel1,
                                    @RequestParam Long categoryLevel2,
                                    @RequestParam Long categoryLevel3,
                                    @RequestParam String statusName,
                                    @RequestParam String appInfo){
       /* AppInfo appinfo = new AppInfo();
        appinfo.setId(new Long(id));
        appinfo.setSoftwarename(softwareName);
        appinfo.setApkname(APKName);
        appinfo.setSupportrom(supportROM);
        appinfo.setInterfacelanguage(interfaceLanguage);
        appinfo.setSoftwaresize(softwareSize);
        appinfo.setDownloads(downloads);
        appinfo.setFlatformid(flatformId);
        appinfo.setCategorylevel1(categoryLevel1);
        appinfo.setCategorylevel2(categoryLevel2);
        appinfo.setCategorylevel3(categoryLevel3);
        appinfo.setStatus(1L);
        appinfo.setAppinfo(appInfo);
        appInfoService.modifyAppinfo(appinfo);*/
        return "developer/appinfolist";
    }
    @RequestMapping("/updownload")     // 上架下架
    @ResponseBody
    public Object upDownLoad(@RequestParam Long appid){
        ReturnInfo info = new ReturnInfo();

        if("".equals(appid)){
            info.setErrorCode("exception000001");
        }else if (appid == 0){
            info.setErrorCode("param000001");
        }else {
            Integer app = appInfoService.modifyApp(appid.intValue());
            if(app == 1){
                info.setErrorCode("0");
                info.setResultMsg("success");
            }else {
                info.setResultMsg("failed");
            }
        }

        return info;
    }

    @RequestMapping("/logout")      // 退出登录
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/devUser/login";
    }

    @RequestMapping("/main")
    public String main(){
        return "developer/main";
    }
    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    public Object getCategorylevel(@RequestParam(required = false) Integer pid){
        List<Integer> list = null;
        if(pid==null){
            list = Arrays.asList(0);
        }else if(pid==1||pid==2){
            list = Arrays.asList(pid);
        }else if(pid>=3&&pid<=18){
            list = Arrays.asList(3,4);
        }else if(pid>=19&&pid<=28){
            list = Arrays.asList(19,20,21,22);
        }
        List<AppCategory> appCategories = appInfoService.selectByPid(list);
        return appCategories;
    }
    @RequestMapping("/datadictionarylist")
    @ResponseBody
    public Object getDatadictionarylist(@RequestParam String tcode){
        List<DataDictionary> dataDictionaries = appInfoService.selectByTypeCode(tcode);
        return dataDictionaries ;
    }
}
