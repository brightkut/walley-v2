package com.brightkut.walley_v2.model;

import java.util.List;

import lombok.Data;

@Data
public class LineWebhookDto {
    private String destination;
    private List<Event> events;
}