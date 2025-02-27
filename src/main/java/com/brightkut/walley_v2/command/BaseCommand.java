package com.brightkut.walley_v2.command;

public interface BaseCommand {
    String command(String msg,String userId) ;
    String getName();
}
