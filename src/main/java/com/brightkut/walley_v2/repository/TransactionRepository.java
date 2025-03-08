package com.brightkut.walley_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brightkut.walley_v2.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {  
}