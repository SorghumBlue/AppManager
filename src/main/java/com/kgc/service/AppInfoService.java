package com.kgc.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kgc.pojo.AppCategory;
import com.kgc.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {
    Page<AppInfo> selectAll(Integer pageSize, Integer pageNum, EntityWrapper wrapper);
    List<AppCategory> selectById(Integer pid);
    List<AppCategory> selectByList(List list);
}
