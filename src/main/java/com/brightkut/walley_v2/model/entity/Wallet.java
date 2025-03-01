package com.brightkut.walley_v2.model.entity;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@DynamoDBTable(tableName = "wallet")
public class Wallet {
    @DynamoDBHashKey
    private String walletId; // It is a userId from LINE

    @DynamoDBAttribute
    private BigDecimal totalMoney;
}