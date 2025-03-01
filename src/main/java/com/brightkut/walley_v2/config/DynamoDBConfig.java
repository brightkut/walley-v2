package com.brightkut.walley_v2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(buiAmazonDynamoDB());
    }

    private AmazonDynamoDB buiAmazonDynamoDB(){
        return AmazonDynamoDBClientBuilder
                    .standard()
                    .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                            "dynamodb.ap-southeast-1.amazonaws.com", 
                            "ap-southeast-1"
                            )
                    )
                    .withCredentials(
                        new AWSStaticCredentialsProvider(
                            new BasicAWSCredentials(
                                System.getenv("WALLEY_AWS_ACCESS_KEY"),
                                System.getenv("WALLEY_AWS_SECRET_KEY")
                            )
                        )
                    ).build();
    }
}