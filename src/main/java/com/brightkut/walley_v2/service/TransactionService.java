package com.brightkut.walley_v2.service;

import org.springframework.stereotype.Service;

import com.brightkut.walley_v2.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    // public String save(){

    // }
}
