package com.brightkut.walley_v2.command.category;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Category;
import com.brightkut.walley_v2.repository.CategoryRepository;
import com.brightkut.walley_v2.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Component
public class ManageCategoryCommand implements BaseCommand {
    
    private static final Logger log = LoggerFactory.getLogger(ManageCategoryCommand.class);

    private final CategoryRepository categoryRepository;
    private final WalletRepository walletRepository;
    
    
    public ManageCategoryCommand(CategoryRepository categoryRepository, WalletRepository walletRepository){
        this.categoryRepository = categoryRepository;
        this.walletRepository = walletRepository;
    }

    @Transactional
    @Override
    public String command(String msg, String userId) {
        String[] command = msg.split(" ");
        var subCommand = command[1];
        var categoryName = command[2];
        
        var wallet = walletRepository.findById(userId);

        if(!wallet.isPresent()){
            log.error("Error occur when wallet does not found");
            return CommonConstant.WALLET_NOT_FOUND_RES;
        }

        if(CommonConstant.ADD.equals(subCommand)){      
            // check category name already exist
            var category = categoryRepository.findByCategoryName(userId, categoryName);

            if(category.isPresent()){
                log.error("Error occur when category name = {} already exist", categoryName);
                return CommonConstant.CREATE_CATEGORY_DUPLICATE_RES;
            }
            
            var saveCategory = new Category()
            .setCategoryName(categoryName)
            .setWallet(wallet.get()); // Set the wallet reference

            wallet.get().getCategories().add(saveCategory); // Ensure wallet has the new category

            categoryRepository.save(saveCategory);

            return String.format(CommonConstant.CREATE_CATEGORY_RES, categoryName);

        }else if(CommonConstant.DELETE.equals(subCommand)){
            var category = categoryRepository.findByCategoryName(userId, categoryName);

            if(!category.isPresent()){
                log.error("Error occur when category name = {} not found", categoryName);
                return CommonConstant.CATEGORY_NOT_FOUND_RES;
            }

            categoryRepository.delete(category.get());

            return String.format(CommonConstant.DELETE_CATEGORY_RES, categoryName);

        }else if(CommonConstant.VIEW.equals(subCommand)){
            var categories = categoryRepository.findAllByWalletId(userId);

            if(CollectionUtils.isEmpty(categories)){
                return CommonConstant.CATEGORY_EMPTY_RES;
            }

            return this.getViewCategoryRes(categories);
        }

        return CommonConstant.CREATE_CATEGORY_INVALID_RES;
    }

    @Override
    public String getName() {
        return CommonConstant.MANAGE_CATEGORY;
    }
    
    private String getViewCategoryRes(List<Category> categories){
        var sb = new StringBuilder(CommonConstant.NEW_LINE);

        sb.append(CommonConstant.VIEW_CATEGORY_RES);

        int count = 1; 

        for(var c: categories){
            sb.append(String.format(CommonConstant.VIEW_CATEGORY_LIST_RES, String.valueOf(count), c.getCategoryName()));
            count++;
        }

        return sb.toString();
    }
}
