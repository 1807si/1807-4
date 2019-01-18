package com.duo.my.shop.web.admin.service.impl;

import com.duo.my.shop.domain.TbContentCategory;
import com.duo.my.shop.web.admin.dao.TbContentCategoryDao;
import com.duo.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;
    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByParentId(Long id) {
        return tbContentCategoryDao.selectByParentId(id);
    }
}
