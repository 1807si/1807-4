package com.duo.my.shop.web.admin.service;

import com.duo.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();

    List<TbContentCategory> selectByParentId(Long id);
}
