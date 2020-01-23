package com.kgc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kgc.pojo.AppInfo;

import java.util.List;

public interface AppInfoMapper extends BaseMapper<AppInfo> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);


    List<AppInfo> selectAll(String querySoftwareName, Long queryStatus,
                            Long queryFlatformId,
                            Long queryCategoryLevel1,
                            Long queryCategoryLevel2,
                            Long queryCategoryLevel3);
}