package com.brightkut.walley_v2.command.category;

import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class ViewAllCategoryCommand implements BaseCommand {

    @Override
    public String command(String msg, String userId) {
        return CommonConstant.VIEW_ALL_CATEGORY_RES;
    }

    @Override
    public String getName() {
        return CommonConstant.VIEW_ALL_CATEGORY;
    }
    
}
