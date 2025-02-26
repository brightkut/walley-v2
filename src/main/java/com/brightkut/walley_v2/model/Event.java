package com.brightkut.walley_v2.model;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Event {
    private String type;
    private Message message;
    private String webhookEventId;

    private DeliveryContext deliveryContext;
    private BigInteger timestamp;
    private Source source;
    private String replyToken;
    private String mode;
}
