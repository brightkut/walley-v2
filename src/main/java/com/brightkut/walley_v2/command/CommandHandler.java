package com.brightkut.walley_v2.command;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.brightkut.walley_v2.command.wallet.ViewWalletCommand;
import com.brightkut.walley_v2.constant.CommonConstant;

@Component
public class CommandHandler {
    private final HashMap<String, BaseCommand> commands;
    
    private final ViewWalletCommand viewWalletCommand;

    public CommandHandler(
        ViewWalletCommand viewWalletCommand
    ) {
        this.viewWalletCommand = viewWalletCommand;
        commands = new HashMap<>();
        commands.put(CommonConstant.VIEW_WALLET, this.viewWalletCommand);
    }

     public BaseCommand getCommand(String commandMessage){
        if(commands.containsKey(commandMessage))
            return commands.get(commandMessage);

        return null;
    }

    public String handle(String msg,String userId){
        BaseCommand command = this.getCommand(msg);

        if(ObjectUtils.isEmpty(command)) return CommonConstant.ERROR_COMMAND_NOT_FOUND;

        return command.command(msg,userId);
    }
}
