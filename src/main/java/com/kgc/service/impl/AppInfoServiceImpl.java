package com.kgc.service.impl;

        import com.baomidou.mybatisplus.mapper.EntityWrapper;
        import com.baomidou.mybatisplus.plugins.Page;
        import com.kgc.dao.*;
        import com.kgc.pojo.AppCategory;
        import com.kgc.pojo.AppInfo;
        import com.kgc.pojo.AppVersion;
        import com.kgc.pojo.DataDictionary;
        import com.kgc.service.AppInfoService;
        import org.springframework.stereotype.Service;

        import javax.annotation.Resource;
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


}
