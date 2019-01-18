package com.duo.my.shop.web.admin.web.controller;

import com.duo.my.shop.domain.TbContentCategory;
import com.duo.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value="list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();
        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }


    @ResponseBody
    @RequestMapping(value="detail",method = RequestMethod.POST)
    public List<TbContentCategory> detail(Long id){
        if(id==null){
            id=0L;
        }
        List<TbContentCategory> tbContentCategories   =  tbContentCategoryService.selectByParentId(id);
        return tbContentCategories;
    }

    /**
     * 递归
     * @param sourceList 源集合
     * @param targetList 经过排序后的集合
     * @param parentId  父分类的id
     * @return
     */
    public void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory : sourceList) {
            if(tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);
                if(tbContentCategory.isParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        if(contentCategory.getParentId().equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }





}
