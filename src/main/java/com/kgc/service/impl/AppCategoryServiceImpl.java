package com.kgc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.kgc.dao.AppCategoryMapper;
import com.kgc.pojo.AppCategory;
import com.kgc.service.AppCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryMapper categoryMapper;

    @Override
    public List<AppCategory> findAllLevel1() {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        wrapper.like("categorycode","All");

        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> findAppLevel2() {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        wrapper.eq("parentid",1);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> findGameLevel2() {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        wrapper.eq("parentid",2);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> findAllLevel3(Long pid) {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        if(pid == null || "".equals(pid)){
            wrapper.gt("parentid",2);
        }
        wrapper.eq("parentid",pid);

        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> AllLevel2() {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        List<Integer> nums = Arrays.asList(1,2);
        wrapper.in("parentid",nums);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> AllLevel3() {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        wrapper.gt("parentid",2);
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<AppCategory> AddLevel(Long pid) {
        EntityWrapper<AppCategory> wrapper = new EntityWrapper<>();
        if(pid == null){
            wrapper.like("categorycode","All");
        }else {
            wrapper.eq("parentid",pid);
        }

        return categoryMapper.selectList(wrapper);
    }


}
