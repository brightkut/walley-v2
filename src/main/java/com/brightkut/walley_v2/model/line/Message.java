package com.brightkut.walley_v2.model.line;

import java.math.BigInteger;

import lombok.Data;

@Data
public class Message {
    private String type;
    private BigInteger id;
    private String text;
}