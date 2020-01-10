package com.kgc.service;

import com.kgc.pojo.AppCategory;
import com.kgc.pojo.AppInfo;
import com.kgc.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    AppInfo selectById(Integer id,Integer vid);
    //查找所属平台
    DataDictionary selectByvalueid(Integer valueid);
    //查找平台状态
    DataDictionary selectByStatus(Integer status);
    //分类查找
    List<AppCategory> selectBycategory(Integer cateoryLevel1, Integer cateoryLevel2, Integer cateoryLevel3);
    //修改审核状态
    int updateStatus(Integer id, Integer statusid);
    //查找软件名称
    AppInfo selectName(Integer id);
}
