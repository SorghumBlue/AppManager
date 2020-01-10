package com.kgc.service.impl;

import com.kgc.dao.AppVersionMapper;
import com.kgc.pojo.AppVersion;
import com.kgc.service.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppVersionImpl implements AppVersionService {
    @Resource
    AppVersionMapper versionMapper;
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
}
