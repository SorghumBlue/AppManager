package com.kgc.service;

import com.kgc.pojo.AppVersion;

import java.util.List;

public interface AppVersionService {
    List<AppVersion> selectAll();
    AppVersion selectById(Integer id);
    int updateByid(AppVersion appVersion);
    int add(AppVersion appVersion);
}
