package com.brightkut.walley_v2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linecorp.bot.spring.boot.handler.annotation.LineMessageHandler;
import com.brightkut.walley_v2.model.Message;
import com.brightkut.walley_v2.model.line.LineWebhookDto;
import com.linecorp.bot.messaging.client.MessagingApiClient;
import com.linecorp.bot.messaging.model.ReplyMessageRequest;
import com.linecorp.bot.messaging.model.TextMessage;



@LineMessageHandler
@RestController
@RequestMapping("/webhooks")
public class LineWebhookController {

    private final MessagingApiClient lineMessagingClient;

    public LineWebhookController(MessagingApiClient lineMessagingClient){
        this.lineMessagingClient = lineMessagingClient;
    }

    @PostMapping
    public ResponseEntity<Message> handleWebhook(@RequestBody LineWebhookDto payload) {
        System.out.println(payload);
        if(!ObjectUtils.isEmpty(payload) && !CollectionUtils.isEmpty(payload.getEvents())){
            lineMessagingClient.replyMessage(
                new ReplyMessageRequest.Builder(payload.getEvents().getFirst().getReplyToken(), List.of(new TextMessage("Send Line back")))
                .build()
            ).join();
        }

        return ResponseEntity.ok(new Message().setMessage("WalleyV2 send message back successfully."));
    }
}