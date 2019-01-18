package com.duo.my.shop.web.admin.dao;

import com.duo.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {

    List<TbContentCategory> selectAll();


    List<TbContentCategory> selectByParentId(Long id);
}
