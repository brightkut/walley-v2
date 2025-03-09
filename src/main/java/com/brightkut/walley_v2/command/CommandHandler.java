package com.brightkut.walley_v2.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.brightkut.walley_v2.command.category.ViewAllCategoryCommand;
import com.brightkut.walley_v2.command.wallet.ViewWalletCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class CommandHandler {
    private final List<BaseCommand> commands;
    
    private final ViewWalletCommand viewWalletCommand;
    private final ViewAllCategoryCommand manageCategoryCommand;


    public CommandHandler(
        ViewWalletCommand viewWalletCommand,
        ViewAllCategoryCommand manageCategoryCommand
    ) {
        this.viewWalletCommand = viewWalletCommand;
        this.manageCategoryCommand = manageCategoryCommand;
        
        commands = new ArrayList<>();
        commands.add(this.viewWalletCommand);
        commands.add(this.manageCategoryCommand);
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
