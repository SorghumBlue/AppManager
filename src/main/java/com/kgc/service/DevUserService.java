package com.kgc.service;

import com.kgc.pojo.DevUser;

import java.util.List;

public interface DevUserService {
    List<DevUser> selectAll();
    DevUser selectOneByDevCode(String devCode, String devPassword);
}
