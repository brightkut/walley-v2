package com.brightkut.walley_v2.command.category;


import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.service.CategoryService;
import com.brightkut.walley_v2.service.WalletService;

@Component
public class CreateCategoryCommand implements BaseCommand {

    private final WalletService walletService;
    private final CategoryService categoryService;
    
    public CreateCategoryCommand(WalletService walletService, CategoryService categoryService) {
        this.walletService = walletService;
        this.categoryService = categoryService;
    }

    @Override
    public String command(String msg, String userId) {
        String[] command = msg.split(" ");

        var wallet = walletService.getWallet(userId);

        if(CommonConstant.ADD.equals(command[1])){
            return categoryService.save(userId, command[2]);
        }else if(CommonConstant.DELETE.equals(command[1])){

        }

        return CommonConstant.CREATE_CATEGORY_INVALID_RES;
    }

    @Override
    public String getName() {
        return CommonConstant.CREATE_CATEGORY;
    }
    
}
