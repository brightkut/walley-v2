package com.brightkut.walley_v2.command.category;

import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class ManageCategoryCommand implements BaseCommand {

    @Override
    public String command(String msg, String userId) {
        return CommonConstant.MANAGE_CATEGORY_RES;
    }

    @Override
    public String getName() {
        return CommonConstant.MANAGE_CATEGORY;
    }
    
}
