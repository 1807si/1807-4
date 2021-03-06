package com.duo.my.shop.web.admin.dao;

import com.duo.my.shop.domain.TbUser;
import com.duo.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface TbUserDao {
    /**
     * 查询所有用户
     */
    List<TbUser> selectAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    TbUser selectByid(Long id);

    /**
     * 把javabean添加到数据库里
     * @param tbUser
     */
    void insertTbUser(TbUser tbUser);

    /**
     * 删除的方法
     * @param id
     */
    void deleteById(Long id);

    /**
     * 更新
     * @param tbUser
     */
    void updateTbUser(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    TbUser getUserByEmail(String email);

    List<TbUser> selectBySearch(TbUser tbUser);

    void deleteTbUsers(String[] ids_arr);

    int count(TbUser tbUser);

    List<TbUser> selectByPage(Map<String,Object> map);
}
