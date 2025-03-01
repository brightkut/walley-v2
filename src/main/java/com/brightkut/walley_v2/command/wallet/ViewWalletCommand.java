package com.brightkut.walley_v2.command.wallet;

import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.service.WalletService;

@Component
public class ViewWalletCommand implements BaseCommand{

    private final WalletService walletService;

    public ViewWalletCommand(WalletService walletService){
        this.walletService = walletService;
    }
    
    @Override
    public String command(String msg, String userId) {
        return walletService.getWallet(userId);
    }

    @Override
    public String getName() {
        return CommonConstant.VIEW_WALLET;
    }
    
}
