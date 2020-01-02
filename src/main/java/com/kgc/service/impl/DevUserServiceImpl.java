package com.kgc.service.impl;

import com.kgc.dao.DevUserMapper;
import com.kgc.pojo.DevUser;
import com.kgc.service.DevUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;
    @Override
    public List<DevUser> selectAll() {
        List<DevUser> devUsers = devUserMapper.selectList(null);
        return devUsers;
    }

    @Override
    public DevUser selectOneByDevCode(String devCode, String devPassword) {
        DevUser devUser = new DevUser();
        devUser.setDevcode(devCode);
        DevUser user = devUserMapper.selectOne(devUser);
        if(user!=null && user.getDevpassword().equals(devPassword)){
            return user;
        }
        return null;
    }
}
