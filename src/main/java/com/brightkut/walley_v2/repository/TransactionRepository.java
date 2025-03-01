package com.brightkut.walley_v2.repository;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.brightkut.walley_v2.model.entity.Transaction;

@Repository
public class TransactionRepository {
    private final DynamoDBMapper dynamoDBMapper;

    public TransactionRepository(DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Transaction save(Transaction transaction){
        dynamoDBMapper.save(transaction);

        return transaction;
    }

    public Transaction getById(String transactionId) {
        return dynamoDBMapper.load(Transaction.class, transactionId);
    }

    public String update(String transactionId, Transaction transaction){
        dynamoDBMapper.save(transaction, 
            new DynamoDBSaveExpression()
                .withExpectedEntry("transactionId", 
                    new ExpectedAttributeValue(
                        new AttributeValue()
                            .withS(transactionId)
                    )
            )
         );

        return transactionId;
    }

    public String delete(String transactionId){
        Transaction transaction = dynamoDBMapper.load(Transaction.class, transactionId);
        dynamoDBMapper.delete(transaction);

        return "Transactiond id : " + transactionId + " was deleted";
    }
}
