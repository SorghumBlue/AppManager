package com.kgc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kgc.pojo.AppCategory;

public interface AppCategoryMapper extends BaseMapper<AppCategory> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}