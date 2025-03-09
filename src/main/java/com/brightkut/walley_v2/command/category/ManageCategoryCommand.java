package com.brightkut.walley_v2.command.category;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Category;
import com.brightkut.walley_v2.repository.CategoryRepository;
import com.brightkut.walley_v2.repository.WalletRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

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
                .setCategoryName(userId)
                .setWallet(wallet.get());

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

        }

        return CommonConstant.CREATE_CATEGORY_INVALID_RES;
    }

    @Override
    public String getName() {
        return CommonConstant.MANAGE_CATEGORY;
    }
    
}
