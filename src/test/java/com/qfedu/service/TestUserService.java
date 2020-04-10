package com.qfedu.service;

import com.qfedu.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther Zhangbo
 * @date 2020/4/10 14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUserService {

    @Resource
    private UsersService  usersService;


    @Test
    public void testSelectByPage(){

        List<Users> list = usersService.queryAllByLimit(0, 100);

        for (Users u: list){
            System.out.println(u);
        }
    }

    @Test
    public void testSelectOne(){

        Users u = usersService.queryById("20190514112608");
        System.out.println(u);
    }

}
