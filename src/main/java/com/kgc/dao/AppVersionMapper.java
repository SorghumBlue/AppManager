package com.kgc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kgc.pojo.AppVersion;

public interface AppVersionMapper extends BaseMapper<AppVersion> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);
}