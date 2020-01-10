package com.kgc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kgc.dao.AppCategoryMapper;
import com.kgc.dao.AppInfoMapper;
import com.kgc.dao.AppVersionMapper;
import com.kgc.dao.DataMapper;
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
    AppInfoMapper appInfoMapper;
    @Resource
    AppVersionMapper appVersion;
    @Override
    public AppInfo selectById(Integer id,Integer vid) {
        AppInfo appInfo = this.appInfoMapper.selectById(id);
        AppVersion appVersion = this.appVersion.selectById(vid);
        appInfo.setAppVersion(appVersion);
        return appInfo;
    }
    @Resource
    DataMapper dataMapper;
    @Override
    public DataDictionary selectByvalueid(Integer valueid) {
        //查找所属平台
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("typecode","APP_FLATFORM");
        wrapper.eq("valueid",valueid);
        List<DataDictionary> list = dataMapper.selectList(wrapper);
        DataDictionary data = list.get(0);
        return data;
    }

    @Override
    public DataDictionary selectByStatus(Integer status) {
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
    public List<AppCategory> selectBycategory(Integer cateoryLevel1, Integer cateoryLevel2, Integer cateoryLevel3) {
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
    public int updateStatus(Integer id, Integer statusid) {
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
