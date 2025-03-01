package com.brightkut.walley_v2.model.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "wallet")
public class Wallet {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String walletId;

    @DynamoDBAttribute
    private String totalMoney;

    @DynamoDBAttribute
    private String userId;
}