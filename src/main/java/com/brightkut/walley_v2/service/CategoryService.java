package com.brightkut.walley_v2.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Category;
import com.brightkut.walley_v2.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    
    public String save(String walletId , String categoryName){
        // var category = categoryRepository.findByCategoryName(walletId, categoryName);

        // if(!ObjectUtils.isEmpty(category)){
        //     return CommonConstant.CREATE_CATEGORY_DUPLICATE_RES;
        // }

        // Category saveCategory = new Category().setCategoryName(categoryName);

        // categoryRepository.save(saveCategory);
        
        return String.format(CommonConstant.CREATE_CATEGORY_RES, categoryName);
    }
}
