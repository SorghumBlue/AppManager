package com.kgc.service.impl;

import com.kgc.dao.BackendUserMapper;
import com.kgc.dao.DataDictionaryMapper;
import com.kgc.pojo.BackendUser;
import com.kgc.pojo.DataDictionary;
import com.kgc.service.BackendUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    private BackendUserMapper backendUserMapper;
    @Resource
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public BackendUser selectByLogin(String usercode, String userpassword) {
        BackendUser user = new BackendUser();
        user.setUsercode(usercode);
        BackendUser user1 = backendUserMapper.selectOne(user);
        if(user1 != null &&userpassword.equals(user1.getUserpassword())){
            DataDictionary data = new DataDictionary();
            data.setTypecode(user1.getTypeCode());
            data.setValueid(user1.getUsertype());
            DataDictionary dataDictionary = dataDictionaryMapper.selectOne(data);
            user1.setUserTypeName(dataDictionary.getValuename());
            return user1;
        }else {
            return null;
        }
    }
}
