package com.kgc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kgc.dao.DataDictionaryMapper;
import com.kgc.pojo.DataDictionary;
import com.kgc.service.DataDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryMapper dataMapper;

    @Override
    public List<DataDictionary> findAllStatus() {
        EntityWrapper<DataDictionary> wrapper = new EntityWrapper<>();
        wrapper.eq("typecode","APP_STATUS");
        return dataMapper.selectList(wrapper);
    }

    @Override
    public List<DataDictionary> findAllFlat() {
        EntityWrapper<DataDictionary> wrapper = new EntityWrapper<>();
        wrapper.eq("typecode","APP_FLATFORM");
        return dataMapper.selectList(wrapper);
    }

    @Override
    public List<DataDictionary> findSomeAll(String tcode) {
        EntityWrapper<DataDictionary> wrapper = new EntityWrapper<>();
        wrapper.eq("typecode",tcode);
        return dataMapper.selectList(wrapper);
    }

    /*@Override
    public DataDictionary findOneMes(Integer valueid) {
        return dataMapper.selectById(valueid);
    }*/
}
