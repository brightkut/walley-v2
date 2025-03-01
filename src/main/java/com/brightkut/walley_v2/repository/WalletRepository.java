package com.brightkut.walley_v2.repository;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.brightkut.walley_v2.model.entity.Wallet;

@Repository
public class WalletRepository {
    private final DynamoDBMapper dynamoDBMapper;

    public WalletRepository(DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Wallet save(Wallet wallet){
        dynamoDBMapper.save(wallet);

        return wallet;
    }

    public Wallet getById(String walletId) {
        return dynamoDBMapper.load(Wallet.class, walletId);
    }

    public String update(String walletId, Wallet wallet){
        dynamoDBMapper.save(wallet, 
            new DynamoDBSaveExpression()
                .withExpectedEntry("walletId", 
                    new ExpectedAttributeValue(
                        new AttributeValue()
                            .withS(walletId)
                    )
            )
         );

        return walletId;
    }

    public String delete(String walletId){
        Wallet wallet = dynamoDBMapper.load(Wallet.class, walletId);
        dynamoDBMapper.delete(wallet);

        return "Walletd id : " + walletId + " was deleted";
    }
}
