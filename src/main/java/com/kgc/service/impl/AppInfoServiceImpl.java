package com.kgc.service.impl;

        import com.baomidou.mybatisplus.mapper.EntityWrapper;
        import com.baomidou.mybatisplus.plugins.Page;
        import com.kgc.dao.AppCategoryMapper;
        import com.kgc.dao.AppInfoMapper;
        import com.kgc.dao.AppVersionMapper;
        import com.kgc.dao.DataDictionaryMapper;
        import com.kgc.pojo.AppCategory;
        import com.kgc.pojo.AppInfo;
        import com.kgc.pojo.AppVersion;
        import com.kgc.pojo.DataDictionary;
        import com.kgc.service.AppInfoService;
        import org.springframework.stereotype.Service;

        import javax.annotation.Resource;
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
            //查询所属平台
            flat.setTypecode(appInfo.getFlatTypeCode());
            flat.setValueid(appInfo.getFlatformid());
            DataDictionary flatData = dataDictionaryMapper.selectOne(flat);
            appInfo.setFlatformname(flatData.getValuename());
            //查询App状态
            status.setTypecode(appInfo.getStatusTypeCode());
            status.setValueid(appInfo.getStatus());
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
}
