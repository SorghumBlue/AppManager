package com.kgc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kgc.pojo.DevUser;

public interface DevUserMapper extends BaseMapper<DevUser> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}