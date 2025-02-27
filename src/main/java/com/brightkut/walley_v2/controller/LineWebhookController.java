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

import okhttp3.OkHttpClient;

import com.brightkut.walley_v2.command.CommandHandler;
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
    private final CommandHandler commandHandler;

    public LineWebhookController(MessagingApiClient lineMessagingClient, CommandHandler commandHandler){
        this.lineMessagingClient = lineMessagingClient;
        this.commandHandler = commandHandler;
    }

    @PostMapping
    public ResponseEntity<Message> handleWebhook(@RequestBody LineWebhookDto payload) {
        System.out.println(payload);
        if(!ObjectUtils.isEmpty(payload) && !CollectionUtils.isEmpty(payload.getEvents())){
            var userMessage = payload.getEvents().getFirst().getMessage().getText();
            var userId = payload.getEvents().getFirst().getSource().getUserId();
            
            // Send message to command handler and process
            var respMessage = commandHandler.handle(userMessage, userId);

            // Send message back to user
            lineMessagingClient.replyMessage(
                new ReplyMessageRequest.Builder(payload.getEvents().getFirst().getReplyToken(), List.of(new TextMessage(respMessage)))
                .build()
            ).join();

        }

        return ResponseEntity.ok(new Message().setMessage("WalleyV2 send message back successfully."));
    }
}