package com.kgc.service.impl;

        import com.baomidou.mybatisplus.mapper.EntityWrapper;
        import com.baomidou.mybatisplus.plugins.Page;
        import com.kgc.dao.*;
        import com.kgc.pojo.AppCategory;
        import com.kgc.pojo.AppInfo;
        import com.kgc.pojo.AppVersion;
        import com.kgc.pojo.DataDictionary;
        import com.kgc.service.AppCategoryService;
        import com.kgc.service.AppInfoService;
        import com.kgc.service.AppVersionService;
        import com.kgc.service.DataDictionaryService;
        import org.springframework.stereotype.Service;

        import javax.annotation.Resource;
        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;
    @Resource
    private AppCategoryMapper appCategoryMapper;
    @Resource
    private AppVersionMapper appVersionMapper;

    @Resource
    private DataDictionaryService dataDicService;
    @Resource
    private AppCategoryService categoryService;
    @Resource
    private AppVersionService versionService;

    @Override
    public Page<AppInfo> selectAll(Integer pageSize, Integer pageNum,EntityWrapper wrapper) {
        Page<AppInfo> page = new Page<AppInfo>(pageNum,pageSize);
        List<AppInfo> appInfos = appInfoMapper.selectPage(page, wrapper);
        DataDictionary flat = new DataDictionary();
        DataDictionary status = new DataDictionary();
        AppCategory appCategory = new AppCategory();
        AppVersion appVersion = new AppVersion();
        for (AppInfo appInfo : appInfos) {
            System.out.println("==========="+appInfo);
            //查询所属平台
            flat.setTypecode(appInfo.getFlatTypeCode());
            flat.setValueid(appInfo.getFlatformid());
            DataDictionary flatData = dataDictionaryMapper.selectOne(flat);
            appInfo.setFlatformname(flatData.getValuename());
            //查询App状态
            status.setTypecode(appInfo.getStatusTypeCode());
            status.setValueid(appInfo.getStatus());
            System.out.println(status);
            DataDictionary statusData = dataDictionaryMapper.selectOne(status);
            appInfo.setStatusname(statusData.getValuename());
            //查询一级分类
            AppCategory appCategory1 = appCategoryMapper.selectById(appInfo.getCategorylevel1());
            appInfo.setCategorylevel1name(appCategory1.getCategoryname());
            //查询二级分类
            AppCategory appCategory2 = appCategoryMapper.selectById(appInfo.getCategorylevel2());
            appInfo.setCategorylevel2name(appCategory2.getCategoryname());
            //查询三级分类
            AppCategory appCategory3 = appCategoryMapper.selectById(appInfo.getCategorylevel3());
            appInfo.setCategorylevel3name(appCategory3.getCategoryname());
            //查询版本号
            if(appInfo.getVersionid()!=null){
                appVersion.setId(appInfo.getVersionid());
            }else {
                appVersion.setAppid(appInfo.getId());
            }
            AppVersion version = appVersionMapper.selectOne(appVersion);
            if(version!=null){
                appInfo.setVersionno(version.getVersionno());
            }else {
                appInfo.setVersionno(null);
            }
        }
        page.setRecords(appInfos);
        return page;
    }

    @Override
    public List<AppCategory> selectById(Integer pid) {
        List<AppCategory> appCategories = appCategoryMapper.selectList(new EntityWrapper<AppCategory>().in("parentId", pid.toString()));
        return appCategories;
    }

    @Override
    public List<AppCategory> selectByList(List list) {
        List<AppCategory> appCategories = appCategoryMapper.selectList(new EntityWrapper<AppCategory>().in("parentid", list));
        return appCategories;
    }
    @Resource
    AppVersionMapper appVersion;
    @Override
    public AppInfo selectById(Integer id, Integer vid) {
        AppInfo appInfo = appInfoMapper.selectById(id);
        AppVersion Version = appVersion.selectById(vid);
        appInfo.setAppVersion(Version);
        return appInfo;
    }

    @Resource
    DataMapper dataMapper;
    @Override
    public DataDictionary selectByvalueid(Long valueid) {
        //查找所属平台
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("typecode","APP_FLATFORM");
        wrapper.eq("valueid",valueid);
        List<DataDictionary> list = dataMapper.selectList(wrapper);
        DataDictionary data = list.get(0);
        return data;
    }

    @Override
    public DataDictionary selectByStatus(Long status) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("typecode","APP_STATUS");
        wrapper.eq("valueid",status);
        List<DataDictionary> list = dataMapper.selectList(wrapper);
        DataDictionary dataDictionary = list.get(0);
        return dataDictionary;
    }

    @Resource
    AppCategoryMapper aMapper;
    @Override
    public List<AppCategory> selectBycategory(Long cateoryLevel1, Long cateoryLevel2, Long cateoryLevel3) {
        List<AppCategory> list = new ArrayList<AppCategory>();
        AppCategory category1 = aMapper.selectById(cateoryLevel1);
        AppCategory category2 = aMapper.selectById(cateoryLevel2);
        AppCategory category3 = aMapper.selectById(cateoryLevel3);
        list.add(category1);
        list.add(category2);
        list.add(category3);
        return list;
    }

    @Override
    public int updateStatus(Long id, Long statusid) {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus(statusid);
        Integer update = appInfoMapper.updateById(appInfo);
        return update;
    }

    @Override
    public AppInfo selectName(Integer id) {
        AppInfo appInfo = appInfoMapper.selectById(id);
        return appInfo;
    }


    @Override
    public Page<AppInfo> selectAllBySome(Integer pageIndex, Integer pageSize, String querySoftwareName, Long queryStatus, Long queryFlatformId, Long queryCategoryLevel1, Long queryCategoryLevel2, Long queryCategoryLevel3) {
        EntityWrapper<AppInfo> wrapper = new EntityWrapper<>();
        Page<AppInfo> page = new Page(pageIndex, pageSize);
        if(querySoftwareName != null && !"".equals(querySoftwareName)){
            wrapper.like("softwarename",querySoftwareName);
        }
        if(queryStatus != null && queryStatus != 0 ){
            wrapper.eq("status",queryStatus);
        }
        if(queryFlatformId != null && queryFlatformId != 0 ){
            wrapper.eq("flatformid",queryFlatformId);
        }
        if(queryCategoryLevel1 != null && queryCategoryLevel1 != 0 ){
            wrapper.eq("categorylevel1",queryCategoryLevel1);
        }
        if(queryCategoryLevel2 != null && queryCategoryLevel2 != 0 ){
            wrapper.eq("categorylevel2",queryCategoryLevel2);
        }
        if(queryCategoryLevel3 != null && queryCategoryLevel3 != 0 ){
            wrapper.eq("categorylevel3",queryCategoryLevel3);
        }
        List<AppInfo> appInfos = appInfoMapper.selectPage(page,wrapper);
        List<DataDictionary> status = dataDicService.findAllStatus();
        List<DataDictionary> allFlat = dataDicService.findAllFlat();
        List<AppCategory> level1 = categoryService.findAllLevel1();
        List<AppCategory> level2 = categoryService.AllLevel2();
        List<AppCategory> level3 = categoryService.AllLevel3();
        List<AppVersion> list = versionService.findAll();
        for(AppInfo info : appInfos){
            for(DataDictionary data:allFlat){     // 平台
                if(info.getFlatformid() == data.getValueid()){
                    info.setFlatformname(data.getValuename());
                    break;
                }
            }
            for(AppCategory level : level1){     // 一级分类
                if(info.getCategorylevel1() == level.getId()){
                    info.setCategorylevel1name(level.getCategoryname());
                    break;
                }
            }
            for(AppCategory level : level2){     // 二级分类
                if(info.getCategorylevel2() == level.getId()){
                    info.setCategorylevel2name(level.getCategoryname());
                    break;
                }
            }
            for(AppCategory level : level3){     // 三级分类
                if(info.getCategorylevel3() == level.getId()){
                    info.setCategorylevel3name(level.getCategoryname());
                    break;
                }
            }
            for(AppVersion ver : list){
                if(info.getVersionid() == ver.getId()){
                    info.setAppVersion(ver);
                }
            }
            for(DataDictionary sta : status){       // 状态
                if(info.getStatus() == sta.getValueid()){
                    info.setStatusname(sta.getValuename());
                    break;
                }
            }
        }
        page.setRecords(appInfos);

        return page;
    }

    @Override
    public Integer insertApp(String softwareName, String APKName, String supportROM, String interfaceLanguage, BigDecimal softwareSize, Long downloads, Long flatformId, Long categoryLevel1, Long categoryLevel2, Long categoryLevel3, String status, String appInfo, String a_logoPicPath) {
        AppInfo info = new AppInfo();
        info.setSoftwarename(softwareName);
        info.setApkname(APKName);
        info.setSupportrom(supportROM);
        info.setInterfacelanguage(interfaceLanguage);
        info.setSoftwaresize(softwareSize);
        info.setDownloads(downloads);
        info.setFlatformid(flatformId);
        info.setCategorylevel1(categoryLevel1);
        info.setCategorylevel2(categoryLevel2);
        info.setCategorylevel3(categoryLevel3);
        info.setStatus(1L);
        info.setAppinfo(appInfo);
        info.setLogopicpath(a_logoPicPath);
        return appInfoMapper.insert(info);
    }

    @Override
    public List<AppInfo> findAll() {
        return appInfoMapper.selectList(null);
    }

    @Override
    public AppInfo AppView(Long appid) {
        AppInfo info = appInfoMapper.selectById(appid);
        List<DataDictionary> list = dataDicService.findAllFlat();
        List<AppCategory> level1 = categoryService.findAllLevel1();
        List<AppCategory> level2 = categoryService.AllLevel2();
        List<AppCategory> level3 = categoryService.AllLevel3();
        List<DataDictionary> status = dataDicService.findAllStatus();
        for(DataDictionary data : list){
            if(info.getFlatformid().equals(data.getValueid())){
                info.setFlatformname(data.getValuename());
                break;
            }
        }
        for(AppCategory level : level1){     // 一级分类
            if(info.getCategorylevel1() == level.getId()){
                info.setCategorylevel1name(level.getCategoryname());
                break;
            }
        }
        for(AppCategory level : level2){     // 二级分类
            if(info.getCategorylevel2() == level.getId()){
                info.setCategorylevel2name(level.getCategoryname());
                break;
            }
        }
        for(AppCategory level : level3){     // 三级分类
            if(info.getCategorylevel3() == level.getId()){
                info.setCategorylevel3name(level.getCategoryname());
                break;
            }
        }
        for(DataDictionary sta : status){       // 状态
            if(info.getStatus() == sta.getValueid()){
                info.setStatusname(sta.getValuename());
                break;
            }
        }
        return info;
    }

    @Override
    public Integer delApp(Long appid) {
        Integer in = versionService.delByAppId(appid);
        return appInfoMapper.deleteById(appid);
    }

    @Override
    public Integer modifyApp(Long appid) {
        AppInfo appInfo = appInfoMapper.selectById(appid);
//        EntityWrapper<AppInfo> wrapper = new EntityWrapper<>();
        if(appInfo.getStatus() == 2 || appInfo.getStatus() == 5){     // 审核通过或是已下架的状态，可以上架
            appInfo.setStatus(4L);
//            wrapper.eq("status",4);
        }else if(appInfo.getStatus() == 4){                 // APP已上架，可以下架
            appInfo.setStatus(5L);
//            wrapper.eq("status",5);
        }

        return appInfoMapper.updateAllColumnById(appInfo);
    }


}
