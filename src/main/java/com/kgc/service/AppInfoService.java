package com.kgc.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kgc.pojo.AppCategory;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    Page<AppInfo> selectAll(Integer pageSize, Integer pageNum, EntityWrapper wrapper);
    List<AppCategory> selectById(Integer pid);
    List<AppCategory> selectByList(List list);
    AppInfo selectById(Integer id,Integer vid);
    //查找所属平台
    DataDictionary selectByvalueid(Long valueid);
    //查找平台状态
    DataDictionary selectByStatus(Long status);
    //分类查找
    List<AppCategory> selectBycategory(Long cateoryLevel1, Long cateoryLevel2, Long cateoryLevel3);
    //修改审核状态
    int updateStatus(Long id, Long statusid);
    //查找软件名称
    AppInfo selectName(Integer id);
}
