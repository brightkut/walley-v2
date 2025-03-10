package com.brightkut.walley_v2.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.brightkut.walley_v2.command.transaction.ManageTransactionCommand;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.brightkut.walley_v2.command.category.ManageCategoryCommand;
import com.brightkut.walley_v2.command.category.ViewAllCategoryCommand;
import com.brightkut.walley_v2.command.wallet.ViewWalletCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class CommandHandler {
    private final List<BaseCommand> commands;
    
    private final ViewWalletCommand viewWalletCommand;
    private final ViewAllCategoryCommand viewAllCategoryCommand;
    private final ManageCategoryCommand manageCategoryCommand;
    private final ManageTransactionCommand manageTransactionCommand;


    public CommandHandler(
            ViewWalletCommand viewWalletCommand,
            ViewAllCategoryCommand viewAllCategoryCommand,
            ManageCategoryCommand manageCategoryCommand, ManageTransactionCommand manageTransactionCommand
    ) {
        this.viewWalletCommand = viewWalletCommand;
        this.viewAllCategoryCommand = viewAllCategoryCommand;
        this.manageCategoryCommand = manageCategoryCommand;
        this.manageTransactionCommand = manageTransactionCommand;

        commands = new ArrayList<>();
        commands.add(this.viewWalletCommand);
        commands.add(this.viewAllCategoryCommand);
        commands.add(this.manageCategoryCommand);
        commands.add(this.manageTransactionCommand);
    }

     public BaseCommand getCommand(String commandMessage){
        for(BaseCommand command : commands) if(commandMessage.contains(command.getName())) return command;
        
        return null;
    }

    public String handle(String msg,String userId){
        BaseCommand command = this.getCommand(msg);

        if(ObjectUtils.isEmpty(command)) return CommonConstant.ERROR_COMMAND_NOT_FOUND;

        return command.command(msg,userId);
    }
}
