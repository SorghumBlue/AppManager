package com.kgc.service.impl;

import com.kgc.dao.BackendUserMapper;
import com.kgc.pojo.BackendUser;
import com.kgc.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    BackendUserMapper backendUserMapper;
    @Override
    public BackendUser selectByLogin(String usercode, String userpassword) {
        BackendUser user = new BackendUser();
        user.setUsercode(usercode);
        BackendUser user1 = backendUserMapper.selectOne(user);
        if(user1 != null &&userpassword.equals(user1.getUserpassword())){
            return user1;
        }else {
            return null;
        }
    }
}
