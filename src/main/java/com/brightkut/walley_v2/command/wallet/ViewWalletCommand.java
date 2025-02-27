package com.brightkut.walley_v2.command.wallet;

import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class ViewWalletCommand implements BaseCommand{

    @Override
    public String command(String msg, String userId) {
        return "จำนวณเงิน 0 บาท";
    }

    @Override
    public String getName() {
        return CommonConstant.VIEW_WALLET;
    }
    
}
