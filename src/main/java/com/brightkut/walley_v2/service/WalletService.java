package com.brightkut.walley_v2.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.brightkut.walley_v2.constant.CommonConstant;
import com.brightkut.walley_v2.model.entity.Wallet;
import com.brightkut.walley_v2.repository.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    public String getWallet(String walletId){
        var wallet = walletRepository.getById(walletId);
        
        if(ObjectUtils.isEmpty(wallet)){
            wallet = new Wallet()
                .setWalletId(walletId)
                .setTotalMoney(BigDecimal.ZERO);

            walletRepository.save(wallet);

            return String.format(CommonConstant.CREATE_WALLET_RES, wallet.getTotalMoney());
        }

        return String.format(CommonConstant.VIEW_WALLET_RES, wallet.getTotalMoney());
    }
}
