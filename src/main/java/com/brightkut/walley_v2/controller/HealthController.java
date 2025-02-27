package com.brightkut.walley_v2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightkut.walley_v2.model.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Message> health() {
        return ResponseEntity.ok(new Message().setMessage("Server is healthy and running."));
    }
    
}