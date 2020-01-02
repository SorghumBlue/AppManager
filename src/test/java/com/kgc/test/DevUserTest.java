package com.kgc.test;

import com.kgc.pojo.DevUser;
import com.kgc.service.DevUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DevUserTest {
    @Resource
    private DevUserService devUserService;
    @Test
    public void test01(){
        List<DevUser> devUsers = devUserService.selectAll();
        for (DevUser devUser : devUsers) {
            System.out.println(devUser);
        }
    }
}
