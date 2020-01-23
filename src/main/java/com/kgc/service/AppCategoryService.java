package com.kgc.service;

import com.kgc.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    List<AppCategory> findAllLevel1();
    List<AppCategory> findAppLevel2();
    List<AppCategory> findGameLevel2();
    List<AppCategory> findAllLevel3(Long pid);

    List<AppCategory> AllLevel2();
    List<AppCategory> AllLevel3();
    List<AppCategory> AddLevel(Long pid);
}
