package com.brightkut.walley_v2.command.wallet;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.brightkut.walley_v2.command.BaseCommand;
import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Wallet;
import com.brightkut.walley_v2.repository.WalletRepository;

@Component
public class ViewWalletCommand implements BaseCommand{

    private final WalletRepository walletRepository;

    public ViewWalletCommand(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }
    
    @Override
    public String command(String msg, String userId) {
        var wallet = walletRepository.findById(userId);
        
        if(!wallet.isPresent()){
            Wallet saveWallet = new Wallet()
                .setWalletId(userId)
                .setTotalMoney(BigDecimal.ZERO);

            walletRepository.save(saveWallet);

            return String.format(CommonConstant.CREATE_WALLET_RES, saveWallet.getTotalMoney());
        }

        return String.format(CommonConstant.VIEW_WALLET_RES, wallet.get().getTotalMoney());
    }

    @Override
    public String getName() {
        return CommonConstant.VIEW_WALLET;
    }
    
}
