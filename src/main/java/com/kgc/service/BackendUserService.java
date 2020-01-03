package com.kgc.service;

import com.kgc.pojo.BackendUser;

public interface BackendUserService {
    BackendUser selectByLogin(String usercode,String userpassword);
}
