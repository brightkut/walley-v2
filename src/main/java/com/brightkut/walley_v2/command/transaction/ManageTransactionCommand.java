package com.brightkut.walley_v2.command.transaction;

import com.brightkut.walley_v2.command.BaseCommand;
import org.springframework.stereotype.Component;

import static com.brightkut.walley_v2.constant.CommonConstant.MANAGE_TRANSACTION;
import static com.brightkut.walley_v2.constant.CommonConstant.MANAGE_TRANSACTION_RES;

@Component
public class ManageTransactionCommand implements BaseCommand {
    @Override
    public String command(String msg, String userId) {
        return MANAGE_TRANSACTION_RES;
    }

    @Override
    public String getName() {
        return MANAGE_TRANSACTION;
    }
}
