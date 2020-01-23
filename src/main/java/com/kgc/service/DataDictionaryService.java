package com.kgc.service;

import com.kgc.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> findAllStatus();  // 查询所有状态
    List<DataDictionary> findAllFlat();    // 查询所有所属平台
    List<DataDictionary> findSomeAll(String typecode);

//    DataDictionary findOneMes(Integer valueid);
}
