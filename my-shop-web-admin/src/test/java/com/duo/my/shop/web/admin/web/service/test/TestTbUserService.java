package com.duo.my.shop.web.admin.web.service.test;

import com.duo.my.shop.domain.TbUser;
import com.duo.my.shop.web.admin.dao.TbUserDao;
import com.duo.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TestTbUserService {
    @Autowired
    TbUserDao tbUserDao;
    @Test
    public void testSeleteAll(){
        List<TbUser> tbUsers = tbUserDao.selectAll();
        System.out.println(tbUsers);
    }
    @Test
    public void testSelectById(){
        TbUser tbUser = tbUserDao.selectByid(7L);
        System.out.println(tbUser);

    }
    @Test
    public void testInsertTbUser(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("xiaolu");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        tbUser.setEmail("xiaolu@qq.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserDao.insertTbUser(tbUser);
    }

    @Test
    public void testDeleteById(){
        tbUserDao.deleteById(36L);
    }

    @Test
    public void testUpdateTbUser(){
        TbUser tbUser = tbUserDao.selectByid(37L);
        tbUser.setPhone("18888888888");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUserDao.updateTbUser(tbUser);
    }

    @Test
    public void testSelectByUsername(){
        List<TbUser> users = tbUserDao.selectByUsername("i");
        System.out.println(users);
    }

}
