package com.kgc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kgc.pojo.DataDictionary;

public interface DataDictionaryMapper extends BaseMapper<DataDictionary> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}