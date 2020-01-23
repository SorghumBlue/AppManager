package com.kgc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kgc.dao.AppVersionMapper;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.AppVersion;
import com.kgc.pojo.DataDictionary;
import com.kgc.service.AppInfoService;
import com.kgc.service.AppVersionService;
import com.kgc.service.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppVersionImpl implements AppVersionService {
    @Resource
    AppVersionMapper versionMapper;

    @Resource
    private AppInfoService infoService;
    @Resource
    private DataDictionaryService dataDicService;

    @Override
    public List<AppVersion> selectAll() {
        List<AppVersion> appVersions = versionMapper.selectList(null);
        return appVersions;
    }

    @Override
    public AppVersion selectById(Integer id) {
        AppVersion appVersion = versionMapper.selectById(id);
        return appVersion;
    }

    @Override
    public int updateByid(AppVersion appVersion) {
        Integer i = versionMapper.updateById(appVersion);
        return i;
    }

    @Override
    public int add(AppVersion appVersion) {
        Integer insert = versionMapper.insert(appVersion);
        return insert;
    }

    @Override
    public List<AppVersion> findAll() {
        return versionMapper.selectList(null);
    }

    @Override
    public List<AppVersion> findByAppId(Long appid) {
        EntityWrapper<AppVersion> wrapper = new EntityWrapper<>();
        wrapper.eq("appid",appid);
        List<AppVersion> list = versionMapper.selectList(wrapper);   // 版本
        AppInfo appInfo = infoService.AppView(appid);           // App名称
        List<DataDictionary> pubstatus = dataDicService.findSomeAll("PUBLISH_STATUS");
        for(AppVersion app : list ){
            app.setAppname(appInfo.getSoftwarename());
            for(DataDictionary data : pubstatus){       // 发布状态
                if(app.getPublishstatus() == data.getValueid()){
                    app.setPublishstatusname(data.getValuename());
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public Integer delByAppId(Long appid) {
        return versionMapper.deleteById(appid);
    }
}
